public class Solution_Day_64 {
    class Solution {
        public int binarySearchFirst(int num, int[] nums){
            int s = 0;
            int e = nums.length-1;
            int first = -1;
            while(s<=e){
                int mid = s + (e-s) / 2;
                if(nums[mid] == num){
                    if(mid==0 || nums[mid-1]!=num){
                        first = mid;
                        break;
                    }else{
                        e = mid-1;
                    }
                }else if(nums[mid] < num){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            return first;
        }
        public int binarySearchLast(int num, int[] nums){
            int s = 0;
            int e = nums.length-1;
            int last = -1;
            while(s<=e){
                int mid = s + (e-s)/2;
                if(nums[mid] == num){
                    if(mid==nums.length-1 || nums[mid+1]!=num){
                        last = mid;
                        break;
                    }else{
                        s = mid+1;
                    }
                }else if(nums[mid] < num){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            return last;
        }


        public int[] searchRange(int[] nums, int target) {
            int x1 = binarySearchFirst(target,nums);
            int x2 = binarySearchLast(target, nums);
            // System.out.println(x)
            int arr[] = {x1, x2};
            return arr;
        }
    }
}
