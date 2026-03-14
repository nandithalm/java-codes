//Dynamic Programming

//recursion

import java.util.*;

public class Main {

    static int solve(int index, int[] heights, int k) {

        if (index == 0)
            return 0;

        int minEnergy = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {

            if (index - j >= 0) {

                int jump = solve(index - j, heights, k) +
                        Math.abs(heights[index] - heights[index - j]);

                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return minEnergy;
    }

    public static void main(String[] args) {

        int[] heights = {15, 4, 1, 14, 15};
        int k = 4;

        int n = heights.length;

        System.out.println(solve(n - 1, heights, k));
    }
}

//memoization

import java.util.*;

public class Main {

    static int solve(int index, int[] heights, int k, int[] dp) {

        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int minEnergy = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {

            if (index - j >= 0) {

                int jump = solve(index - j, heights, k, dp) +
                        Math.abs(heights[index] - heights[index - j]);

                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return dp[index] = minEnergy;
    }

    public static void main(String[] args) {

        int[] heights = {15, 4, 1, 14, 15};
        int k = 4;

        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(solve(n - 1, heights, k, dp));
    }
}

//tabulation

import java.util.*;

public class Main {

    public static int frogJump(int[] heights, int k) {

        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {

                    int jump = dp[i - j] +
                            Math.abs(heights[i] - heights[i - j]);

                    minEnergy = Math.min(minEnergy, jump);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[] heights = {15, 4, 1, 14, 15};
        int k = 4;

        System.out.println(frogJump(heights, k));
    }
}

//Space Optimization

import java.util.*;

public class Main {

    public static int frogJump(int[] heights, int k) {

        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {

                    int jump = dp[i - j] +
                            Math.abs(heights[i] - heights[i - j]);

                    minEnergy = Math.min(minEnergy, jump);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[] heights = {15, 4, 1, 14, 15};
        int k = 4;

        System.out.println(frogJump(heights, k));
    }
}
