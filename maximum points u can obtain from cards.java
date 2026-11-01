//sliding window
//two pointer
//leetcode

import java.util.*;

class Solution {

    public static int maximumSum(int[] nums, int k) {

        int n = nums.length;

        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            lsum = lsum + nums[i];
        }

        maxSum = lsum;

        int rindex = n - 1;

        for (int i = k - 1; i >= 0; i--) {

            lsum = lsum - nums[i];

            rsum = rsum + nums[rindex];

            rindex = rindex - 1;

            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {6, 2, 3, 4, 7, 2, 1, 7, 1};

        int k = 4;

        System.out.println(maximumSum(nums, k));
    }
}
