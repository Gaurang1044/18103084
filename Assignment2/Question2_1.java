package Assignment2;

import java.util.Scanner;

public class Question2_1 {
    static int comp(String a, String b) {
        int n = a.length() > b.length() ? b.length() : a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return (int) a.charAt(i) - (int) b.charAt(i);
            }
        }
        if (a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter First String : ");
        String first = in.nextLine();
        System.out.print("Enter Second String : ");
        String second = in.nextLine();
        int a = comp(first, second);
        if (a > 0)
            System.out.println(String.format("'%s' is lexographically greater than '%s'", first, second));
        else if (a < 0)
            System.out.println(String.format("'%s' is lexographically smaller than '%s'", first, second));
        else {
            System.out.println(String.format("'%s' is lexographically equal to '%s'", first, second));
        }
        in.close();
    }
}