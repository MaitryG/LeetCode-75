import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_Day_87 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer,Integer> freq = new HashMap<>();
            int max = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < nums.length; i++){
                int c = freq.getOrDefault(nums[i],0)+1;
                freq.put(nums[i], c);
                list.add(nums[i]);
                if(freq.get(nums[i]) > max){
                    max = freq.get(nums[i]);
                }
            }


            int min = Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> m : freq.entrySet()){
                if((int)m.getValue() == max){
                    int num = (int)m.getKey();
                    int n1 = list.indexOf(num);
                    int n2 = list.lastIndexOf(num);

                    if(n2-n1 + 1 < min){
                        min = n2-n1+1;
                    }
                }
            }
            return min;
        }
    }
}
