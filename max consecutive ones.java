//leetcode
//greedy and two pointer

**brute force approach**

  class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int zeros = 0;

            for (int j = i; j < n; j++) {

                if (nums[j] == 0) {
                    zeros++;
                }

                if (zeros <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
                else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
//time complexity -> Time Complexity: \(O(n^2)\) – Two nested loops.
//Space Complexity: \(O(1)\) – Only a few variables are used.

2. Optimal Approach – Sliding Window (Two Pointers)

  class Solution {
    public int longestOnes(int[] nums, int k) {

        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            if (zeros <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }
}
//Complexity	Value	Reason
//Time	\(O(n)\)	Both pointers move forward at most n times
//Space	\(O(1)\)	Only variables are used

  **Optimal approach – Using List and Sliding Window**

  class Solution {
    public int longestOnes(List<Integer> nums, int k) {

        int left = 0;
        int right = 0;
        int zeros = 0;
        int maxLen = 0;

        while (right < nums.size()) {

            if (nums.get(right) == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (nums.get(left) == 0) {
                    zeros--;
                }

                left++;
            }

            if (zeros <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }
}

//Time Complexity: \(O(n)\)
//Space Complexity: \(O(1)\)
