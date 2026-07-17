//optimal approach
class Solution {
    public int missingNumber(int[] nums) {

        int xor1 = 0;
        int xor2 = 0;

        int N = nums.length;

        for (int i = 0; i < N; i++) {
            xor2 ^= nums[i];
            xor1 ^= (i + 1);
        }

        return xor1 ^ xor2;
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//brute force
class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Check every number from 1 to n
        for (int i = 1; i <= n; i++) {

            int flag = 0;

            // Search for i in the array
            for (int j = 0; j < n; j++) {

                if (nums[j] == i) {
                    flag = 1;
                    break;
                }
            }

            // If i is not found, return it
            if (flag == 0) {
                return i;
            }
        }

        // If all numbers 1 to n are present,
        // then the answer is n + 1
        return n + 1;
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//better(hashing)
class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Create a hash array of size n + 1
        int[] hash = new int[n + 1];

        // Mark the numbers present in the array
        for (int i = 0; i < n; i++) {

            // Ignore numbers less than 1 or greater than n
            if (nums[i] >= 1 && nums[i] <= n) {
                hash[nums[i]] = 1;
            }
        }

        // Find the first number that is missing
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        // If all numbers from 1 to n are present
        return n + 1;
    }
}
