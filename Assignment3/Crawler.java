import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    private Queue<String> queue;
    private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
    private HashSet<String> set;

    // public void addLink(String org, String fin) {
    //     String ad;
    //     if (fin.startsWith("/")) {
    //         ad = org.concat(fin);
    //     } else {
    //         ad = fin;
    //     }
    // }

    public void parse(String link) {
        // Ek hi site multiple ke liye
        if (set.contains(link)) {
            return;
        }
        set.add(link);

        Document doc = null;

        try {
            doc = Jsoup.connect(link).userAgent(USER_AGENT).get();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //get every tag and add to excel here 
        Elements links = doc.getElementsByTag("a");

        for (Element link1 : links) {
            String url = link1.absUrl("href");
            String text = link1.text();
            
            //Add to xcel here 
            // System.out.println(text + ", " + url);

            // Self loops ke liye thoda sa

            if (!set.contains(url)) {
                queue.add(url);
            }
        }

    }

    Crawler() {
        queue = new LinkedList<String>();
        set = new HashSet<String>();

        System.out.println("Start");

        queue.add("https://pec.ac.in/");

        int depth = 0;

        while (depth < 2) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                parse(queue.peek());
                queue.remove();
                System.out.println("Size of set is:" + set.size());
            }
            System.out.println("Size of set is:" + set.size());
    
            depth++;
        }
        System.out.println("Size of set is:" + set.size());
    }

    public static void main(String[] args) {
        new Crawler();
    }
}
