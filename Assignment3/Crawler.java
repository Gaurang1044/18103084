package Assignment3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    // private static final Boolean MODE_APPEND = true;
    private Queue<String> queue;
    private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
    private HashSet<String> links_set;
    private final String initial_link = "https://pec.ac.in/";
    private final String downloadable_links = "download_links.csv";
    private final String dataAll = "dataAll.csv";
    private final String dataFaculty = "dataFaculty.csv";
    private ArrayList<String> related_words = new ArrayList<String>();
    private PrintWriter linkWriter = null, facultyWriter = null, downWriter = null;

    public boolean validUrl(String link) {
        try {
            URL u = new URL(link); // this would check for the protocol like http or fts
            u.toURI(); // does the extra checking required for validation of URI
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void parse(String crawled_link) {

        // if (links_set.contains(crawled_link)) {
        // return;
        // }
        links_set.add(crawled_link);

        Document doc = null;

        try {
            doc = Jsoup.connect(crawled_link).userAgent(USER_AGENT).get();
        } catch (UnsupportedMimeTypeException e) {
            // downloadable links like .jpg, .pdf, .png are caught here and added to csv.
            downWriter.print(crawled_link);
            newLine(downWriter);
            return;

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract all data from the page.

        Elements text = doc.select("p");
        StringBuilder temp = new StringBuilder("");
        int words = 0;
        for (Element t : text) {
            String z = t.text();
            String lower = z.toLowerCase();
            // This loop checks whether it contains any word related to faculty
            for (String s : related_words) {
                if (lower.contains(s)) {
                    words++;
                }
            }

            temp.append(z.replaceAll(",", ""));
        }
        if (words > 5) {
            facultyWriter.print(crawled_link + ",<p>," + temp);
            newLine(facultyWriter);
        }

        linkWriter.print(crawled_link + ",<p>," + temp);
        newLine(linkWriter);

        // Extract all parsable links from the page.
        Elements links = doc.getElementsByTag("a");

        for (Element link : links) {
            String url = link.absUrl("href");

            if (!validUrl(url) || links_set.contains(url) || !url.contains("pec")) {
                continue;
            }
            queue.add(url);
            links_set.add(url);
        }

    }

    private void newLine(PrintWriter pw) {
        pw.println();
        pw.flush();
    }

    Crawler() {

        System.out.println("Start Crawler");
        System.out.println("Initial Site : " + initial_link);

        // Queue used to crawl the links in BFS Manner
        queue = new LinkedList<String>();

        // Set prevents revisiting already Visited Links
        links_set = new HashSet<String>();

        // download_set = new HashSet<String>();
        queue.add(initial_link);
        links_set.add(initial_link);

        // Words that classify a page or link as faculty related
        String[] rel = { "teacher", "faculty", "professor", "teaching", "assistant", "prof", "scholar", "phd" };

        for (int i = 0; i < rel.length; i++) {
            related_words.add(rel[i]);
        }

        // Opening the files where data is to be written
        FileOutputStream outputStream, outputStream1, outputStream2;
        try {
            outputStream = new FileOutputStream(dataAll);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            linkWriter = new PrintWriter(bufferedWriter);
            linkWriter.print("link,tag,text");
            newLine(linkWriter);

            outputStream1 = new FileOutputStream(downloadable_links);
            BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream1));
            downWriter = new PrintWriter(bufferedWriter1);
            downWriter.print("link");
            newLine(downWriter);

            outputStream2 = new FileOutputStream(dataFaculty);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream2));
            facultyWriter = new PrintWriter(bufferedWriter2);
            facultyWriter.print("link,tag,text");
            newLine(downWriter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Indicates when to stop the crawler
        int max_links = 2000;
        int crawled = 0;
        while (queue.size() > 0) {
            String to_be_crawled_link = queue.remove();
            parse(to_be_crawled_link);
            crawled++;
            System.out.println("Link crawled " + crawled + ": " + to_be_crawled_link);
            if (crawled == max_links) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        new Crawler();
    }
}
