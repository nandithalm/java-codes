//recursion(TUF)

class Solution {

    static int f(int i, int[] nums){

        if(i == 0)
            return nums[0];

        if(i < 0)
            return 0;

        int pick = nums[i] + f(i-2);
        int notPick = f(i-1);

        return Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(int[] nums){

        int n = nums.length;

        return f(n-1, nums);
    }

    public static void main(String[] args){

        int nums[] = {1,7,16,8};

        System.out.println(maximumNonAdjacentSum(nums));
    }
}
//memoization

import java.util.Arrays;

class Solution {

    static int f(int i, int[] nums, int[] dp){

        if(i == 0)
            return nums[0];

        if(i < 0)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int pick = nums[i] + f(i-2, nums, dp);
        int notPick = f(i-1, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(int[] nums){

        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        return f(n-1, nums, dp);
    }
}
//tabulation

class Solution {

    public static int maximumNonAdjacentSum(int[] nums){

        int n = nums.length;

        int dp[] = new int[n];

        dp[0] = nums[0];

        for(int i=1;i<n;i++){

            int pick = nums[i];
            if(i > 1)
                pick += dp[i-2];

            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}
