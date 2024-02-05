public class Solution_Day_12 {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            // int mul = 1;

            // for(int i = 0 ; i < nums.length; i++){
            //     answer[i] = multiply(i, nums);
            // }

            int prefixprod = 1;
            int suffixprod = 1;
            answer[0] = 1;

            for(int i = 1; i < nums.length; i++){
                answer[i] = answer[i-1] * nums[i-1];
            }

            for(int i = nums.length-1; i >=0; i--){
                answer[i] *= suffixprod;
                suffixprod *= nums[i];
            }


            return answer;
        }

        // public static int multiply(int n, int[] nums){
        //     int mul = 1;
        //     for(int j = 0 ; j < nums.length ; j++){
        //         if(j == n){
        //             continue;
        //         }else{
        //                             mul = mul * nums[j];

        //         }
        //     }
        //     return mul;
        // }
}
