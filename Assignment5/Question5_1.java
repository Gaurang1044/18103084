package Assignment5;

public class Question5_1 {

    public static class CounterThread extends Thread {
        public void run() {
            for (int i = 1; i <= 100; i++) {
                if (i % 10 == 0) {
                    // Prints the number whenever number is a multiple of 10
                    System.out.println(i);
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CounterThread t = new CounterThread();
        t.start();
    }
}