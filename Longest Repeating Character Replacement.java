//leetcode
//sliding window and two pointer


class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, maxLen = 0, mf = 0;

        int[] hash = new int[26];

        while (r < s.length()) {

            hash[s.charAt(r) - 'A']++;

            mf = Math.max(mf, hash[s.charAt(r) - 'A']);

            while ((r - l + 1) - mf > k) {

                hash[s.charAt(l) - 'A']--;

                mf = 0;

                for (int i = 0; i < 26; i++) {
                    mf = Math.max(mf, hash[i]);
                }

                l = l + 1;
            }

            if ((r - l + 1) - mf <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }
}
TC : O(N+N)*26
Sc : O(26)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, maxLen = 0, mf = 0;

        int[] hash = new int[26];

        while (r < s.length()) {

            hash[s.charAt(r) - 'A']++;

            mf = Math.max(mf, hash[s.charAt(r) - 'A']);

            if ((r - l + 1) - mf > k) {

                hash[s.charAt(l) - 'A']--;

                mf = 0;

                for (int i = 0; i < 26; i++) {
                    mf = Math.max(mf, hash[i]);
                }

                l = l + 1;
            }

            if ((r - l + 1) - mf <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }
}

