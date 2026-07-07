//leetcode

class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int index = 0;   // Position to write compressed characters
        int i = 0;       // Position to read characters

        while (i < n) {

            char currentChar = chars[i];
            int count = 0;

            // Count consecutive occurrences of currentChar
            while (i < n && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                String cnt = String.valueOf(count);

                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
