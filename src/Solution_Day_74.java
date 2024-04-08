public class Solution_Day_74 {
    class Solution {
        public int rob(int[] nums) {

            int rob1 = 0;
            int rob2 = 0;

            //[rob1, rob2, n, n+1, .....]
            for(int i = 0 ; i < nums.length; i++){
                int temp = Math.max(nums[i] + rob1, rob2);
                rob1 = rob2;
                rob2 = temp;
            }

            return rob2;
        }
    }
}
