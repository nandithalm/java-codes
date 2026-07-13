//leetcode

//1st approach
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        String concat = s+s;
        String trimmed = concat.substring(1,concat.length()-1);
        return trimmed.contains(s);

    
        
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//2nd approach

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {

            if (n % len != 0)
                continue;

            String sub = s.substring(0, len);

            StringBuilder sb = new StringBuilder();

            while (sb.length() < n) {
                sb.append(sub);
            }

            if (sb.toString().equals(s))
                return true;
        }

        return false;
    }
}
