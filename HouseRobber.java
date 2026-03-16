//leetcode (dp)
//tabulation
class Solution {

    // Standard max sum of non-adjacent elements
    static int maxLoot(int[] nums, int start, int end) {
        int prev = nums[start];
        int prev2 = 0;

        for(int i = start+1; i <= end; i++){
            int pick = nums[i] + prev2;
            int notPick = prev;

            int cur = Math.max(pick, notPick);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public static int rob(int[] money){
        int n = money.length;

        if(n == 1) return money[0]; // Only one house

        // Case 1: Rob from 0 to n-2
        int case1 = maxLoot(money, 0, n-2);

        // Case 2: Rob from 1 to n-1
        int case2 = maxLoot(money, 1, n-1);

        return Math.max(case1, case2);
    }

    public static void main(String[] args){
        int money1[] = {2, 1, 4, 9};
        System.out.println(rob(money1)); // 10

        int money2[] = {1, 5, 2, 1, 6};
        System.out.println(rob(money2)); // 11

        int money3[] = {9, 4, 1, 8};
        System.out.println(rob(money3)); // 17
    }
}
