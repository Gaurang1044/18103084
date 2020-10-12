package Assignment2;

import java.util.Scanner;

public class Question2_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = Integer.parseInt(in.nextLine());
        if (n <= 0) {
            System.out.println("Please input Positive Integer only");
            in.close();
            return;
        }
        System.out.print(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            System.out.print(" ");
            System.out.print(n);
        }
        in.close();
    }
}
