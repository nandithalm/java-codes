//A to Z Striver DSA Sheet(greedy)
import java.util.Arrays;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        // Create a 2D array to store start and end together
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort meetings by end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1; // first meeting always selected
        int lastEnd = meetings[0][1];

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }
}
