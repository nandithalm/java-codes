//TUF
//Window Sliding and Two Pointer

**Brute Force Approach**

  import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < n; j++) {

                if (set.contains(s.charAt(j))) {
                    break;
                }

                set.add(s.charAt(j));

                int len = j - i + 1;

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
--------------------------------------------------------------------------------------
Optimal Approach – Sliding Window + Hash Array

  import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int maxLen = 0;
        int l = 0;
        int[] hash = new int[256];

        Arrays.fill(hash, -1);

        for (int r = 0; r < n; r++) {

            if (hash[s.charAt(r)] != -1) {

                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }

            int len = r - l + 1;

            maxLen = Math.max(len, maxLen);

            hash[s.charAt(r)] = r;
        }

        return maxLen;
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
