public class Solution_Day_82 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int i = 0;
            int mid = nums.length/2;
            int left = 0;
            int right = nums.length-1;
            while(left <= right){
                mid = (left+right)/2;
                if(target==nums[mid]){
                    return mid;
                }
                if(target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return left;
        }
    }
}
