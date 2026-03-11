//leetcode
public class Main {

    public static double myPow(double x, int n) {

        long N = n; // convert to long to handle Integer.MIN_VALUE

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {

            if (N % 2 == 1) {     // if power is odd
                result = result * x;
            }

            x = x * x;            // square the base
            N = N / 2;            // divide power by 2
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(myPow(2.0, 10));  // 1024.0
        System.out.println(myPow(2.1, 3));   // 9.261
        System.out.println(myPow(2.0, -2));  // 0.25

    }
}
