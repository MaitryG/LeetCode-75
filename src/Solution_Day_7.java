import java.util.Arrays;

public class Solution_Day_7 {
        public int maxOperations(int[] nums, int k) {
            int count=0;
            int sum;
            int arr[] = new int[nums.length];
            int m = 0;
            // for(int i = 0 ; i < nums.length-1 ; i++){
            //     if(nums[i] > k){
            //         continue;
            //     }
            //     for(int j = i+1; j < nums.length; j++){
            //         if(nums[j] > k){
            //             continue;
            //         }else if(nums[j] < k){
            //             sum = nums[i] + nums[j];
            //             if(sum==k){
            //                 nums[i] = k+1;
            //                 nums[j] = k+1;
            //                 count++;
            //                 break;
            //             }
            //         }
            //     }
            // }
            Arrays.sort(nums);
            int i=0;
            int j = nums.length-1;
            while(i < j){
                if(nums[i] + nums[j]  == k){
                    i++;
                    j--;
                    count++;
                }else if(nums[i] + nums[j] < k){
                    i++;
                }else{
                    j--;
                }
            }

            return count;
        }
}