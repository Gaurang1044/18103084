package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2_3 {
    // Returns true if b>a;
    static Boolean comp(String a, String b) {
        int n = a.length() > b.length() ? b.length() : a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return (int) a.charAt(i) < (int) b.charAt(i);
            }
        }
        return a.length() < b.length();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of input : ");
        int n = Integer.parseInt(in.nextLine());

        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the String " + (i + 1) + ": ");
            String c = in.nextLine();
            arr.add(c);
        }
        in.close();
        for (int i = 0; i < n; i++) {
            String a = arr.get(i);
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                String b = arr.get(j);
                if (comp(b, a)) {
                    a = b;
                    idx = j;
                }
            }
            arr.set(idx, arr.get(i));
            arr.set(i, a);
        }
        System.out.println("Sorted Order is");
        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i));
        }
    }
}
