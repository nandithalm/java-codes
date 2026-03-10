import java.util.Scanner;

public class GCDRecursive {

    // Recursive function to find GCD
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
