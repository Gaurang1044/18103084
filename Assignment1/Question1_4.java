import java.util.Scanner;
import java.util.HashMap;

public class Question1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter The first string : ");
        String s1 = in.nextLine();
        System.out.print("Enter The second string : ");

        String s2 = in.nextLine();
        in.close();
        HashMap<Character, Integer> arr = new HashMap<Character, Integer>();
        HashMap<Character, Integer> brr = new HashMap<Character, Integer>();
        if (s1.length() != s2.length()) {
            System.out.println("Not Anagrams");
        } else {
            for (int i = 0; i < s1.length(); i++) {
                char word = s1.charAt(i);
                int count = arr.containsKey(word) ? arr.get(word) : 0;
                arr.put(word, count + 1);
                word = s2.charAt(i);
                count = brr.containsKey(word) ? brr.get(word) : 0;
                brr.put(word, count + 1);

            }
            Boolean z = true;
            for (Character key : arr.keySet()) {
                if (arr.get(key) != brr.get(key)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }
        }

    }
}