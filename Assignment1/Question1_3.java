package Assignment1;

import java.util.Scanner;
import java.util.ArrayList;

public class Question1_3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Number of Vertices : ");
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> edg = new ArrayList<ArrayList<Integer>>();

        // ArrayList<ArrayList<ArrayList<Integer>>> adj;
        ArrayList<Integer> dist;
        // adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        dist = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            // adj.add(new ArrayList<ArrayList<Integer>>());
            dist.add(Integer.MAX_VALUE / 2);
        }
        System.out.print("Number of Edges : ");
        int e = in.nextInt();
        System.out.println("Enter Dimesions of Edges In Format : From To Weight (0 Indexed)");
        for (int i = 0; i < e; i++) {
            System.out.print("Edge " + (i + 1) + " : ");
            int from = in.nextInt();
            int to = in.nextInt();
            int w = in.nextInt();
            System.out.println();
            ArrayList<Integer> a = new ArrayList<>();
            a.add(from);
            a.add(to);
            a.add(w);
            edg.add(a);
            // adj.get(from).add(new ArrayList<Integer>(Arrays.asList(to, w)));
        }
        System.out.print("Enter Source : ");
        int s = in.nextInt();
        System.out.print("Enter Destination : ");
        int d = in.nextInt();
        dist.set(s, 0);
        for (int i = 0; i < n - 1; i++) {
            int lim = edg.size();
            for (int j = 0; j < lim; j++) {
                int from = edg.get(j).get(0);
                int to = edg.get(j).get(1);
                int w = edg.get(j).get(2);
                // System.out.print("w is " + w);
                dist.set(to, Math.min(dist.get(to), dist.get(from) + w));
            }
            // for (int x = 0; x < n; x++) {
            // System.out.print(dist.get(x) + " ");
            // }
            // System.out.println();
        }
        Boolean x = true;
        for (int i = 0; i < n - 1; i++) {
            int lim = edg.size();
            for (int j = 0; j < lim; j++) {
                int from = edg.get(j).get(0);
                int to = edg.get(j).get(1);
                int w = edg.get(j).get(2);
                if (dist.get(to) > dist.get(from) + w) {
                    x = false;
                    break;
                }
            }
            if (!x)
                break;
        }
        if (!x)
            System.out.println("Negative Cycle Exists");
        else {
            System.out.println("Shortest Distance from Source to Destination : " + dist.get(d));
            System.out.println();
            for (int i = 0; i < n; i++) {
                String out = Integer.toString(dist.get(i));

                if (dist.get(i) >= Integer.MAX_VALUE / 2)
                    out = "NULL";
                System.out.println(String.format("Shortest Distance from Vertex %1$s to Vertex %2$s : " + out, s, i));
            }
        }
        in.close();
    }
}