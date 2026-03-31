//leetcode(Bit Manipulation)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i <= n; i++) {  // FIX HERE
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
