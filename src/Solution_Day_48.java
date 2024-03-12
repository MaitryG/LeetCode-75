public class Solution_Day_48 {
    class Solution {
        public static int binFindPeak(int[] nums, int s, int e){
            if(s==e){
                return s;
            }else{
                int mid = (s+e)/2;
                if(nums[mid] > nums[mid+1]){
                    return binFindPeak(nums, s, mid);
                }else{
                    return binFindPeak(nums, mid+1, e);
                }
            }
        }

        public int findPeakElement(int[] nums) {
            if(nums.length == 1){
                return 0;
            }
            return binFindPeak(nums, 0, nums.length-1);
        }
    }
}
