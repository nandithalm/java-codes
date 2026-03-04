//leetcode next permutation
//arrays
  
  class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int piv = -1;

        // Step 1: Find pivot
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                piv = i;
                break;
            }
        }

        // Step 2: Find next greater element and swap
        if(piv != -1){
            int j = n - 1;

            while(j > piv){
                if(nums[j] > nums[piv]){
                    break;
                }
                j--;
            }

            int temp = nums[piv];
            nums[piv] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse the suffix
        int i = piv + 1;
        int j = n - 1;

        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
