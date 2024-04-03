import java.util.HashMap;

public class Solution_Day_69 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // if(nums.length<2){
            //     return false;
            // }
            // for(int i = 0 ; i < nums.length-1; i++){
            //     int sum =0;
            //     for(int j = i; j < nums.length; j++){
            //         sum = sum + nums[j];
            //         if(sum%k==0 && j!=i){
            //             System.out.println(sum);
            //             return true;
            //         }
            //     }
            // }
            // return false;


            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0,0);

            int sum = 0;

            for(int i = 0 ; i < nums.length;i++){
                int num = nums[i];
                sum += num;
                if(hm.containsKey(sum%k)){
                    if(hm.get(sum%k) < i) {
                        return true;
                    }
                }else{
                    hm.put(sum%k, i+1);
                }
            }

            return false;
        }
    }
}
