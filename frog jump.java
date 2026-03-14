TUF//recursion

import java.util.*;

public class Main {

    public static int frogJump(int i, int[] heights){

        if(i == 0) return 0;

        int oneStep = frogJump(i-1, heights) 
                + Math.abs(heights[i] - heights[i-1]);

        int twoStep = Integer.MAX_VALUE;

        if(i > 1){
            twoStep = frogJump(i-2, heights) 
                + Math.abs(heights[i] - heights[i-2]);
        }

        return Math.min(oneStep, twoStep);
    }

    public static void main(String[] args){

        int[] heights = {2,1,3,5,4};
        int n = heights.length;

        System.out.println(frogJump(n-1, heights));
    }
}

//memoization
import java.util.*;

public class Main {

    public static int frogJump(int i, int[] heights, int[] dp){

        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];

        int oneStep = frogJump(i-1, heights, dp) 
                + Math.abs(heights[i] - heights[i-1]);

        int twoStep = Integer.MAX_VALUE;

        if(i > 1){
            twoStep = frogJump(i-2, heights, dp) 
                + Math.abs(heights[i] - heights[i-2]);
        }

        dp[i] = Math.min(oneStep, twoStep);

        return dp[i];
    }

    public static void main(String[] args){

        int[] heights = {2,1,3,5,4};
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        System.out.println(frogJump(n-1, heights, dp));
    }
}

//tabulation

import java.util.*;

public class Main {

    public static int frogJump(int[] heights){

        int n = heights.length;

        int[] dp = new int[n];

        dp[0] = 0;

        for(int i=1;i<n;i++){

            int oneStep = dp[i-1] 
                    + Math.abs(heights[i] - heights[i-1]);

            int twoStep = Integer.MAX_VALUE;

            if(i>1){
                twoStep = dp[i-2] 
                    + Math.abs(heights[i] - heights[i-2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n-1];
    }

    public static void main(String[] args){

        int[] heights = {2,1,3,5,4};

        System.out.println(frogJump(heights));
    }
}

//space optimized approach
import java.util.*;

public class Main {

    public static int frogJump(int[] heights){

        int n = heights.length;

        int prev = 0;
        int prev2 = 0;

        for(int i=1;i<n;i++){

            int oneStep = prev 
                    + Math.abs(heights[i] - heights[i-1]);

            int twoStep = Integer.MAX_VALUE;

            if(i>1){
                twoStep = prev2 
                    + Math.abs(heights[i] - heights[i-2]);
            }

            int cur = Math.min(oneStep, twoStep);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public static void main(String[] args){

        int[] heights = {2,1,3,5,4};

        System.out.println(frogJump(heights));
    }
}
