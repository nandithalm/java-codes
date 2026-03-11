//recursion
public class Main
{
    public static int[] extendedEuclid(int a, int b)
    {
        if (b == 0) {
            int[] arr = new int[3];
            arr[0] = 1;
            arr[1] = 0;
            arr[2] = a;
            return arr;
        }

        int[] c1 = extendedEuclid(b, a % b);
        int x1 = c1[0];
        int y1 = c1[1];
        int g = c1[2];

        int x = y1;
        int y = x1 - (a / b) * y1;

        int[] c2 = {x, y, g};
        return c2;
    }

    public static void main(String[] args)
    {
        int c[] = extendedEuclid(5, 8);
        System.out.println(c[0] + " " + c[1] + " " + c[2]);
    }
}
