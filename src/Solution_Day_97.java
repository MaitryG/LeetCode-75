import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_Day_97
{
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            // int max = Integer.MIN_VALUE;
            // int min = Integer.MAX_VALUE;
            // for(int i = 0 ; i < nums.length; i++){
            //     if(nums[i] > max){
            //         max = nums[i];
            //     }
            //     if(nums[i] < min){
            //         min = nums[i];
            //     }
            // }
            int n = nums.length;
            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0 ; i < nums.length; i++){
                hs.add(nums[i]);
            }
            int j = 0;
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 1; i <= n ; i++){
                if(!hs.contains(i)){
                    al.add(i);
                }
            }


            return al;

        }
    }
}
