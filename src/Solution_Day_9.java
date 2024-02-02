public class Solution_Day_9 {
    //Given an array of integers(both positive and negative). Pick a subsequence of elements from it such that no two adjacent elements are
//picked and the sum of picked elements is maximized.

        public static void main(String[] args) {
            int[] arr = new int[6];
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 0;
            arr[3] = 5;
            arr[4] = 0;
            arr[5] = 5;

            System.out.println(maxSum(arr, 0));


        }

        private static int maxSum(int[] arr, int i) {
            int[] dp = new int[arr.length];
            for(int j = 0 ; j < arr.length; j++){
                dp[j] = -1;
            }
            if(i >= arr.length){
                return 0;
            }

            dp[i] = Math.max(arr[i] + maxSum(arr, i+1), maxSum(arr, i+2));
            return dp[i];

        }

}
