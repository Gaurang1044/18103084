import java.util.Scanner;

public class Question2_5a {
    static int universe_size = 11;

    public static void printt(boolean[] arr) {
        boolean a = false;
        for (int i = 0; i < universe_size; i++) {
            if (arr[i]) {
                System.out.print(i + ", ");
                a = true;
            }
        }
        if (!a) {
            System.out.println("NULL");
        }
        System.out.println();
    }

    public static void union(boolean[] arr, boolean[] brr) {
        System.out.println("Result of Set Union is :");
        boolean a = false;
        for (int i = 0; i < universe_size; i++) {
            if (arr[i] || brr[i]) {
                System.out.print(i + ", ");
                a = true;
            }
        }
        if (!a) {
            System.out.println("NULL");
        }
        System.out.println();
    }

    public static void intersection(boolean[] arr, boolean[] brr) {
        System.out.println("Result of Set Intersection is :");
        boolean a = false;
        for (int i = 0; i < universe_size; i++) {
            if (arr[i] && brr[i]) {
                System.out.print(i + ", ");
                a = true;
            }
        }
        if (!a) {
            System.out.println("NULL");
        }
        System.out.println();
    }

    public static void compelment(boolean[] arr) {
        boolean a = false;
        for (int i = 0; i < universe_size; i++) {
            if (!arr[i]) {
                System.out.print(i + ", ");
                a = true;
            }
        }
        if (!a) {
            System.out.println("NULL");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean[] arr = new boolean[universe_size];
        boolean[] brr = new boolean[universe_size];
        int a, b;
        System.out.println();
        System.out.print("Number of elements you wish to put in First Set : ");
        a = Integer.parseInt(in.nextLine());

        for (int i = 0; i < a; i++) {
            System.out.print("Enter the element : ");
            int c = Integer.parseInt(in.nextLine());
            if (c > 10 || c < 0) {
                System.out.println("Invalid Input. Valid Range: 0 to 10 both inclusive");
                i--;
            } else {
                arr[c] = true;
            }
        }

        System.out.println();
        System.out.print("Number of elements you wish to put in Second Set : ");
        b = Integer.parseInt(in.nextLine());

        for (int i = 0; i < b; i++) {
            System.out.print("Enter the element : ");
            int c = Integer.parseInt(in.nextLine());

            if (c > 10 || c < 0) {
                System.out.println("Invalid Input. Valid Range: 0 to 10 both inclusive");
                i--;
            } else {
                brr[c] = true;
            }
        }
        System.out.println();

        in.close();
        
        System.out.println("Final Elements in First Set is : ");
        printt(arr);
        
        System.out.println("Final Elements in First Set is : ");
        printt(brr);
        
        long start = System.currentTimeMillis();
        
        System.out.println();
        union(arr, brr);

        System.out.println();
        intersection(arr, brr);

        System.out.println();
        System.out.println("Result of Set Complement of first set is :");
        compelment(arr);

        System.out.println();
        System.out.println("Result of Set Complement of second set is :");
        compelment(brr);
        System.out.println();

        long end = System.currentTimeMillis();
        
        System.out.println("Time taken in Milli Seconds = "+(end-start));
    }
}
