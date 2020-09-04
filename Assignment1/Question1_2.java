import java.util.Scanner;
import java.util.HashSet;

public class Question1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Paragraph : ");
        String input = in.nextLine();
        System.out.print("Number of words : ");
        int n = in.nextInt();
        System.out.print("Enter the Words : ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            set.add(in.next());
        }
        in.close();
        StringBuilder out = new StringBuilder("");
        int a = input.length();
        for (int i = 0; i < a; i++) {
            StringBuilder tmp = new StringBuilder("");
            while (i < a && input.charAt(i) != ' ') {
                tmp.append(input.charAt(i));
                i++;
            }
            StringBuilder fin = new StringBuilder("");
            if (set.contains(tmp.toString())) {
                fin.append(tmp.charAt(0));
                for (int j = 0; j < tmp.length() - 1; j++) {
                    fin.append('*');
                }
            } else {
                fin.append(tmp);
            }
            if (i < a && input.charAt(i) == ' ') {
                fin.append(" ");
            }
            out.append(fin);
        }
        System.out.println(out);
    }

}