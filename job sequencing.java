//takeuforward(greedy)
import java.util.*;

class Solution {
    public static int[] jobSequencing(int[][] jobs) {
        
        // Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        
        int n = jobs.length;
        
        // Find maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        
        // Slot array
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);
        
        int count = 0;
        int profit = 0;
        
        // Schedule jobs
        for (int i = 0; i < n; i++) {
            int deadline = jobs[i][1];
            
            for (int j = deadline; j > 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = jobs[i][0];
                    count++;
                    profit += jobs[i][2];
                    break;
                }
            }
        }
        
        return new int[]{count, profit};
    }

    public static void main(String[] args) {
        int[][] jobs = {
            {1,1,100},
            {2,2,200},
            {3,3,300},
            {4,4,400}
        };

        int[] result = jobSequencing(jobs);
        System.out.println(result[0] + " " + result[1]);
    }
}
