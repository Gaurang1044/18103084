import java.util.Scanner;
import java.util.HashMap;

public class Question1_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter The string : ");
		String s = in.nextLine();
		System.out.print("Enter The substring : ");

		String sub = in.nextLine();
		HashMap<Character, Integer> arr = new HashMap<Character, Integer>();
		HashMap<Character, Integer> brr = new HashMap<Character, Integer>();
		if (s.length() < sub.length())
			System.out.println(0);
		else {
			int out = 0;
			for (int i = 0; i < sub.length(); i++) {
				char word = sub.charAt(i);
				int count = arr.containsKey(word) ? arr.get(word) : 0;
				arr.put(word, count + 1);
				char word2 = s.charAt(i);
				int count2 = brr.containsKey(word2) ? brr.get(word2) : 0;
				brr.put(word2, count2 + 1);
			}
			Boolean z = true;
			for (Character key : arr.keySet()) {
				if (arr.get(key) != brr.get(key)) {
					z = false;
					break;
				}

			}
			if (z)
				out++;
			for (int i = sub.length(); i < s.length(); i++) {
				char rem = s.charAt(i - sub.length());
				char add = s.charAt(i);
				int count = brr.containsKey(rem) ? brr.get(rem) - 1 : 0;
				if (count < 0)
					count = 0;
				brr.put(rem, count);
				count = brr.containsKey(add) ? brr.get(add) : 0;
				brr.put(add, count + 1);
				Boolean k = true;
				for (Character key : arr.keySet()) {
					if (arr.get(key) != brr.get(key)) {
						k = false;
						break;
					}

				}
				if (k)
					out++;
			}
			System.out.println("Occurences : " + out);
		}
		in.close();
	}

}
