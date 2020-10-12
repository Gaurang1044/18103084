package Assignment2;

import java.util.Scanner;

public class Question2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of input : ");
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[21];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the integer : ");
            int c = Integer.parseInt(in.nextLine());
            if (c > 20 || c < 0) {
                i--;
                System.out.println("Invalid Input. Valid Range: 0 to 20 both inclusive");
            } else {
                arr[c]++;
            }
        }
        System.out.println("Sorted order is");
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print(i + ", ");
            }
        }
        in.close();
    }
}
