public class Solution_Day_27 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if(nums.length<3){return false;}
            int dp[] = new int[nums.length];

            //DP Solution Longest Increasing Subsequence - got TLE but it is correct solution
            // Arrays.fill(dp, 1);
            // for(int i = 1 ; i < nums.length; i++){
            //     for(int j = 0 ; j < i; j++){
            //         if(nums[j] < nums[i] && dp[i] <= dp[j]){
            //             dp[i] = dp[j] + 1;
            //             if(dp[i] >= 3){return true;}
            //         }
            //     }
            // }
            // return false;

            int small = Integer.MAX_VALUE;
            int mid = Integer.MAX_VALUE;


            for(int i = 0 ; i < nums.length; i++){
                int big = nums[i];
                if(big<=small){
                    small = big;
                }else if(big<=mid){
                    mid = big;
                }
                else return true;
            }

            return false;


        }
    }

}
