//takeuforward(dynamic programming)
//recursion

class Solution {
    public int ninjaTraining(int[][] points) {
        return solve(points.length - 1, 3, points);
    }

    public int solve(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int merit = points[day][i] + solve(day - 1, i, points);
                max = Math.max(max, merit);
            }
        }
        return max;
    }
}

//Memoization
import java.util.Arrays;

class Solution {
    public int ninjaTraining(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, 3, points, dp);
    }

    public int solve(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return dp[day][last] = max;
        }

        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int merit = points[day][i] + solve(day - 1, i, points, dp);
                max = Math.max(max, merit);
            }
        }

        return dp[day][last] = max;
    }
}

//tabulation

class Solution {
    public int ninjaTraining(int[][] points) {
        int n = points.length;
        int[][] dp = new int[n][4];

        // Base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], 
                     Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int merit = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], merit);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}

//Space Optimization

class Solution {
    public int ninjaTraining(int[][] points) {
        int n = points.length;
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], 
                     Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];

            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        curr[last] = Math.max(curr[last],
                                points[day][task] + prev[task]);
                    }
                }
            }
            prev = curr;
        }

        return prev[3];
    }
}

  
