public class Solution_Day_96 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {

            int count = 0;
            int max = 0;
            for(int i = 0 ; i < nums.length; i++){
                if(nums[i]!=1){
                    count=0;
                }else{
                    count++;
                    if(count > max){
                        max = count;
                    }
                }
            }
            return max;
        }
    }
}
