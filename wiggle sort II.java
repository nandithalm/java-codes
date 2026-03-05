//leetcode
  class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int median = quickSelect(nums, 0, n - 1, (n + 1) / 2);

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } 
            else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } 
            else {
                i++;
            }
        }
    }

    // Virtual index mapping
    private int newIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    // QuickSelect to find kth smallest
    private int quickSelect(int[] nums, int left, int right, int k) {

        while (true) {

            int pivot = partition(nums, left, right);

            if (pivot == k - 1)
                return nums[pivot];
            else if (pivot < k - 1)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
