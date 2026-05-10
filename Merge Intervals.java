//leetcode
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on start value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Add first interval
        result.add(intervals[0]);

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] lastInterval = result.get(result.size() - 1);

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Check overlap
            if (currentStart <= lastInterval[1]) {

                // Merge intervals
                lastInterval[1] = Math.max(lastInterval[1], currentEnd);

            } else {

                // No overlap
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
