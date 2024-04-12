public class Solution_Day_78 {
    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            int err = 0;
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] <= nums[i-1]){
                    if(err > 0) return false;

                    err++;

                    if(i > 1 && nums[i] <= nums[i-2]){
                        nums[i] = nums[i-1];
                    }
                }
            }
            return true;

        }
    }
}
