import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question2_5b {
    static int universe_size = 11;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a, b;

        Set<Integer> arr = new HashSet<Integer>();
        Set<Integer> brr = new HashSet<Integer>();

        Set<Integer> universe = new HashSet<Integer>();
        for (int i = 0; i < universe_size; i++) {
            universe.add(i);
        }

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
                arr.add(c);
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
                brr.add(c);
            }
        }
        System.out.println();

        in.close();
        System.out.println("Final Elements in First Set is : ");
        System.out.println(arr);

        System.out.println();

        System.out.println("Final Elements in First Set is : ");
        System.out.println(brr);

        System.out.println();

        long start = System.currentTimeMillis();

        System.out.println("Result of Set Union is :");
        Set<Integer> uni = new HashSet<Integer>(arr);
        uni.addAll(brr);
        System.out.println(uni);

        System.out.println();

        System.out.println("Result of Set Intersection is :");
        Set<Integer> inter = new HashSet<Integer>(arr);
        inter.retainAll(brr);
        System.out.println(inter);

        System.out.println();

        System.out.println("Result of Set Complement of first set is :");
        Set<Integer> compli1 = new HashSet<Integer>(universe);
        compli1.removeAll(arr);
        System.out.println(compli1);
        
        System.out.println();

        System.out.println("Result of Set Complement of Second set is :");
        Set<Integer> compli2 = new HashSet<Integer>(universe);
        compli2.removeAll(brr);
        System.out.println(compli2);

        System.out.println();
        
        long end = System.currentTimeMillis();
        
        System.out.println("Time taken in Milli Seconds = "+(end-start));
    
    }
}
