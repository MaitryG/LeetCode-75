public class Solution_Day_31 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double max = Double.NEGATIVE_INFINITY;
            if(nums.length==1){
                return nums[0];
            }

            if(k>nums.length){
                return 0;
            }
            double sum = 0;
            double avg = 0;

            for(int i = 0 ; i < k; i++){
                sum+=nums[i];
            }
            avg = sum/k;
            for(int i=k; i < nums.length; i++){
                sum += nums[i] - nums[i-k];
                avg = Math.max(sum/k, avg);
            }

            return avg;

        }
    }
}
