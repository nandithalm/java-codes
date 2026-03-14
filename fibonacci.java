//recursion

import java.util.*;

public class Main {

    static int fib(int n){
        if(n <= 1)
            return n;

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}

//memoization
import java.util.*;

public class Main {

    static int f(int n, int[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(f(n, dp));

        sc.close();
    }
}

//tabulation
import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}

//Space optimixed DP
import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int prev2 = 0;
        int prev = 1;

        for(int i=2;i<=n;i++){
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }

        System.out.println(prev);
    }
}
