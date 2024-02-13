public class Solution_Day_20 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int left_sum = 0;
            int right_sum = 0;
            int pivot;
            for(int i = 0; i < nums.length; i++){
                pivot = i;
                for(int j = 0; j < pivot; j++){
                    left_sum = left_sum + nums[j];
                }

                for(int k = pivot+1; k < nums.length; k++){
                    right_sum = right_sum + nums[k];
                }

                if(right_sum == left_sum){
                    return i;
                }
                left_sum=0;
                right_sum=0;
            }

            return -1;
        }
    }
}
