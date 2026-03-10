public class RecursiveBinarySearch {

    public static int binarySearch(int arr[], int left, int right, int key) {

        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (key < arr[mid]) {
                return binarySearch(arr, left, mid - 1, key);
            }

            return binarySearch(arr, mid + 1, right, key);
        }

        return -1;
    }
