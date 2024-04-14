public class Solution_Day_81 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            int c = 0;

            //    for(int j = 1; j < nums.length-1; j++){
            //         if(nums[j-1] == nums[j]){
            //             int x = nums[j];
            //             for(int i = j+1; i <= nums.length-1; i++){
            //                 nums[i-1] = nums[i];
            //             }
            //             System.out.println(nums[j]);
            //             k++;
            //             j--;
            //             nums[nums.length-1] = x;
            //         }
            //     }

            //     System.out.println(nums.length);
            //     System.out.println(k);

            //     return nums.length-k;

            int j = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i]!=nums[i-1]){
                    nums[j] = nums[i];
                    j++;

                }
            }
            return j;

        }
    }
}
