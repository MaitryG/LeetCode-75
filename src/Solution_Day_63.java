import java.util.HashMap;

public class Solution_Day_63 {
    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            HashMap<Integer, Integer> h = new HashMap<>();

            // for(int i = 0 ; i < h.size(); i++){
            //     System.out.println(h.get(nums[i]));
            // }
            for(int z = 0 ; z <= nums.length-1; z++){
                h.put(nums[z], 0);
            }
            int count=0;
            int max=0;
            int l = 0;
            int r = 0;
            while(l<nums.length && r<nums.length){
                int x = h.get(nums[r])+1;
                h.put(nums[r],x);
                while(h.get(nums[r]) > k){
                    x = h.get(nums[l]) - 1;
                    h.put(nums[l],x);
                    l++;
                }
                max = Math.max(max, r-l+1);
                r++;
            }

            return max;

            //     for(int i = 0 ; i < nums.length-1; i++){
            //         int j = nums.length - 1;
            //         //System.out.println("i" + i);
            //         count = 0;
            //         for(int z = 0 ; z <= j; z++){
            //             h.put(nums[z], 0);
            //         }
            //         while(j >= i){
            //             //System.out.println("j" + j);
            //             int x = h.get(nums[j])+1;
            //             h.put(nums[j], x);
            //             j--;
            //             x=0;
            //             count++;
            //         }

            //         if(isTrue(h, k)){
            //             if(max < count){
            //                 max = count;
            //             }
            //         }

            //     }

            //     count=0;

            //      for(int i = nums.length-1 ; i >= 0; i--){
            //         int j = 0;
            //         //System.out.println("i" + i);
            //         count = 0;
            //         for(int z = i ; z >= j; z--){
            //             h.put(nums[z], 0);
            //         }
            //         while(j <= i){
            //             //System.out.println("j" + j);
            //             int x = h.get(nums[j])+1;
            //             h.put(nums[j], x);
            //             j++;
            //             x=0;
            //             count++;
            //         }

            //         if(isTrue(h, k)){
            //             if(max < count){
            //                 max = count;
            //             }
            //         }
            //     }
            //     count=0;
            //    for(int i = 0 ; i <= nums.length-1; i++){
            //         int j = nums.length-i-1;
            //         count = 0;
            //         for(int z = i ; z >= j; z--){
            //             h.put(nums[z], 0);
            //         }
            //         while(j <= i){
            //             System.out.println("j" + j);
            //             int x = h.get(nums[j])+1;
            //             h.put(nums[j], x);
            //             j++;
            //             x=0;
            //             count++;
            //         }

            //         if(isTrue(h, k)){
            //             System.out.println(count);

            //             if(max < count){
            //                 max = count;
            //             }
            //         }
            //     }


        }

        public boolean isTrue(HashMap<Integer, Integer> h, int k){
            for(int i : h.values()){
                //System.out.println(i);
                if(i>k){
                    // System.out.println(i);
                    return false;
                }
            }

            return true;
        }
    }
}
