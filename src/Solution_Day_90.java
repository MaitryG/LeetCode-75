import java.util.HashMap;

public class Solution_Day_90 {
    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            int c = 0;
            int x = nums.length/2;
            int num = 0;
            int n = (int)Math.floor(x);
            for(int i = 0 ; i < nums.length; i++){
                c = hm.getOrDefault(nums[i],0) + 1;
                hm.put(nums[i], c);
                if(c > n){
                    num = nums[i];
                }

            }


            return num;

        }
    }
}
