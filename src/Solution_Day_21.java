import java.util.*;
public class Solution_Day_21 {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            HashSet<Integer> hs_1 = new HashSet<Integer>();
            for(int val: nums1){
                hs_1.add(val);
            }

            HashSet<Integer> hs_3 = new HashSet<Integer>();
            for(int val: nums2){
                hs_3.add(val);
            }


            List<Integer> al1 = new ArrayList<>(hs_1);
            al1.removeAll(hs_3);
            List<Integer> al2 = new ArrayList<>(hs_3);
            al2.removeAll(hs_1);

            List<List<Integer>> al3 = new ArrayList<>();

            al3.add(al1);
            al3.add(al2);

            return al3;



        }
}
