public class Solution_Day_60 {
    class Solution {
        public int missingNumber(int[] nums) {
            for(int i = 1 ; i < nums.length; i++){
                int key = nums[i];
                int j = i-1;
                while(j >= 0 && nums[j] > key){
                    nums[j+1] = nums[j];
                    j = j - 1;
                }
                nums[j+1] = key;
            }

            int n = nums.length;
            for(int i = 0 ; i < n; i++){
                if(nums[i] != i){
                    return i;
                }
            }

            return n;
        }


    }
}
