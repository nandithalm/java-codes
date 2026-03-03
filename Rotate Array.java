#leetcode 189
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        // Handle cases where k > n
        k = k % n;
        
        // Temporary array to store last k elements
        int[] temp = new int[k];
        
        // Store last k elements
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }
        
        // Shift remaining elements to the right
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        
        // Copy back the stored elements to beginning
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
