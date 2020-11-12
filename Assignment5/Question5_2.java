public class Question5_2 extends Thread {

    public static long maxDiv = 0;
    public static long num = 0;

    public long start;

    public Question5_2(long s) {
        this.start = s;
    }

    public void run() {
        for (long i = this.start; i <= this.start + 10000; i++) {
            long divisors = 0;
            for (long j = i; j > 0; j--) {
                if (i % j == 0) {
                    divisors += 1;
                }
            }
            if (divisors > maxDiv) {
                synchronized (this) {
                    maxDiv = divisors;
                    num = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question5_2 m1 = new Question5_2(1);
        Question5_2 m2 = new Question5_2(10001);
        Question5_2 m3 = new Question5_2(20001);
        Question5_2 m4 = new Question5_2(30001);
        Question5_2 m5 = new Question5_2(40001);
        Question5_2 m6 = new Question5_2(50001);
        Question5_2 m7 = new Question5_2(60001);
        Question5_2 m8 = new Question5_2(70001);
        Question5_2 m9 = new Question5_2(80001);
        Question5_2 m10 = new Question5_2(90001);

        long start_time = System.currentTimeMillis();

        m1.start();
        try {
            m1.join();
        } catch (Exception e) {

        }

        m2.start();
        try {
            m2.join();
        } catch (Exception e) {

        }

        m3.start();
        try {
            m3.join();
        } catch (Exception e) {

        }

        m4.start();
        try {
            m4.join();
        } catch (Exception e) {

        }

        m5.start();
        try {
            m5.join();
        } catch (Exception e) {

        }

        m6.start();
        try {
            m6.join();
        } catch (Exception e) {

        }

        m7.start();
        try {
            m7.join();
        } catch (Exception e) {

        }

        m8.start();
        try {
            m8.join();
        } catch (Exception e) {

        }

        m9.start();
        try {
            m9.join();
        } catch (Exception e) {

        }

        m10.start();
        try {
            m10.join();
        } catch (Exception e) {

        }

        long end_time = System.currentTimeMillis();
        long total_time = end_time - start_time;
        System.out.println("Number: " + num + " has " + maxDiv + " divisors which is maximum in range 1 to 100000.");
        System.out.println("Total time elapsed in milliseconds: " + total_time);
    }
}