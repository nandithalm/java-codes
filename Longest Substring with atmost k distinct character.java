//Sliding Window and two pointer
//leetcode
import java.util.HashMap;

public class Main {

    public static int longestKSubstr(String s, int k) {

        int maxLen = 0;
        int l = 0;
        int r = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {

            mpp.put(s.charAt(r),
                    mpp.getOrDefault(s.charAt(r), 0) + 1);

            while (mpp.size() > k) {

                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);

                if (mpp.get(s.charAt(l)) == 0) {
                    mpp.remove(s.charAt(l));
                }

                l = l + 1;
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r = r + 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestKSubstr(s, k));
    }
}
TC : O(N) + O(N) + log(256)
SC  : O(256)
---------------------------------------------------------------------------------------------------------------------------
  import java.util.HashMap;

public class Main {

    public static int longestKSubstr(String s, int k) {

        int maxLen = 0;
        int l = 0;
        int r = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while (r < s.length()) {

            mpp.put(s.charAt(r),
                    mpp.getOrDefault(s.charAt(r), 0) + 1);

            if (mpp.size() > k) {

                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);

                if (mpp.get(s.charAt(l)) == 0) {
                    mpp.remove(s.charAt(l));
                }

                l = l + 1;
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r = r + 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestKSubstr(s, k));
    }
}
