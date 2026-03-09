public class RecursiveLinearSearch {

    static int linearSearch(int arr[], int n, int key) {
        // Base case: element not found
        if (n == 0)
            return -1;

        // If element found
        if (arr[n - 1] == key)
            return n - 1;

        // Recursive call
        return linearSearch(arr, n - 1, key);
    }

    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40, 50};
        int key = 30;

        int result = linearSearch(arr, arr.length, key);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}
