//sliding window and two pointer
//leetcode

** Brute Force Approach

  
import java.util.*;

class Solution {
    public int totalElements(int[] arr) {

        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> st = new HashSet<>();

            for (int j = i; j < n; j++) {

                st.add(arr[j]);

                if (st.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else {
                    break;
                }
            }
        }

        return maxLen;
    }
}

//Complexity Analysis
- Time Complexity: O(N²) – Two nested loops.
- Space Complexity: O(1) – HashSet stores at most 3 distinct elements before the loop breaks.
How it works:
1.
------------------------------------------------------------------------------------------
  //better approach

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = arr.length;

        while (right < n) {

            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            if (mpp.size() > k) {

                while (mpp.size() > k) {

                    mpp.put(arr[left], mpp.get(arr[left]) - 1);

                    if (mpp.get(arr[left]) == 0) {
                        mpp.remove(arr[left]);
                    }

                    left++;
                }
            }

            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

import java.util.*;

class Solution {
    public int totalFruits(int[] fruits) {

        int n = fruits.length;
        int left = 0;
        int right = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < n) {

            mpp.put(fruits[right], mpp.getOrDefault(fruits[right], 0) + 1);

            if (mpp.size() > 2) {

                mpp.put(fruits[left], mpp.get(fruits[left]) - 1);

                if (mpp.get(fruits[left]) == 0) {
                    mpp.remove(fruits[left]);
                }

                left++;
            }

            if (mpp.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }
}
TC : O(n)
SC : O(n)
Tc : O(2n)
sc: O(n)
  ----------------------------------------------------------------------------------------------
  //optimal approach

