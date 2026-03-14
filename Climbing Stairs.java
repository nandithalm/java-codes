//dynamic programming

1)To identify whether its a dynamic problem or not
step 1: Count the possible ways/return the minimum or possible possible ways possible or needed

2)Now how do you compute it
*Try to reoresent the problem in terms of index
*Do all possible stuffs on that index according to the problem statement
*Sum of all stuffs(count of all ways)
*find the min(if the Qn says)

//recursion
public class Main {

    public static int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}

//Memoization
import java.util.*;

public class Main {

    public static int climbStairs(int n, int[] dp) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(climbStairs(n, dp));
    }
}

//Tabulation
public class Main {

    public static int climbStairs(int n) {

        if (n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(climbStairs(n));
    }
}

//Space optimized DP
public class Main {

    public static int climbStairs(int n) {

        if (n == 1) return 1;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {

            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(climbStairs(n));
    }
}
