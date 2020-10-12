package Assignment2;

public class Question2_4 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            if ((i * i) == ((i * (i + 1)) / 2)) {
                System.out.println("Number required is " + i);
                break;
            }
        }

    }
}
