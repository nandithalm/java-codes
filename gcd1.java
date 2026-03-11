public class GCDArray {

    public static int gcd(int a, int b){
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        //int c[] = extendedEuclid(5,8);
        //System.out.println(c[0] + " " + c[1] + " " + c[2]);

        int arr[] = {1,4,5,3,9};

        int g = gcd(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            g = gcd(g, arr[i]);
        }

        System.out.println(g);
    }
}
