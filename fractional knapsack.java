//greedy(gfg/tuf)
import java.util.*;

class Solution {
    
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        int n = val.length;
        
        double[][] items = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            items[i][0] = (double) val[i] / wt[i]; // ratio
            items[i][1] = i; // store index
        }
        
        // sort by ratio descending
        Arrays.sort(items, (a, b) -> Double.compare(b[0], a[0]));
        
        double totalValue = 0.0;
        
        for (int i = 0; i < n; i++) {
            
            int idx = (int) items[i][1];
            
            if (capacity >= wt[idx]) {
                totalValue += val[idx];
                capacity -= wt[idx];
            } else {
                totalValue += ((double) val[idx] / wt[idx]) * capacity;
                break;
            }
        }
        
        return totalValue;
    }
}
