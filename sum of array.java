public class ArraySum {

    // Recursive function
    static int sumArray(int arr[], int n) {
        // Base case
        if (n == 0)
            return 0;

        // Recursive case
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;

        int sum = sumArray(arr, n);

        System.out.println("Sum of array elements = " + sum);
    }
}
