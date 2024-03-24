public class Solution_Day_59 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int index = nums.length-1;
            for(int i = 0; i <= index; i++){
                if(nums[i] == val){
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    index--;
                    i--;
                }
            }

            return index+1;
        }
    }
}
