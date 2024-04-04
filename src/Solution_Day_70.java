import java.util.HashMap;

public class Solution_Day_70 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // int n = nums.length;
            // for(int i = 0 ; i < nums.length-1; i++){
            //     for(int j = i+1; j < nums.length; j++){
            //         if(nums[i] + nums[j] == target){
            //             return new int[]{i,j};
            //         }
            //     }
            // }
            // return new int[]{};


            //value : index
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i = 0 ; i < nums.length; i++){
                int difference = target - nums[i];
                if(hm.containsKey(difference)){
                    return new int[]{hm.get(difference), i};
                }else{
                    hm.put(nums[i], i);
                }
            }

            return new int[]{};
        }
    }
}
