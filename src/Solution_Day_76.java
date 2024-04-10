public class Solution_Day_76 {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            nums[n-1] = 0;

            if(n==1){
                return nums[0] == 0;
            }

            for(int i = n-2; i>=0; i--){
                int temp = nums[i];
                nums[i] = Integer.MAX_VALUE;

                if(temp!=0){
                    for(int j = 1; j<=temp && i+j < n; j++){
                        if(nums[i+j] != Integer.MAX_VALUE){
                            nums[i] = Math.min(nums[i], nums[i+j] + 1);
                        }
                    }
                }
            }

            return nums[0] > n ? false : true;

        }
    }
}
