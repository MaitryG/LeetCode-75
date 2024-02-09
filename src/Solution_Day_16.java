//https://cses.fi/problemset/task/1634
public class Solution_Day_16 {
    public class CoinsCombinationMin {
        public static int minCoins(int[] arr, int[] dp, int sum){
            if(sum<0){
                return -1;
            }

            if(sum==0){
                return 0;
            }
            int temp = 0;
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < arr.length; j++){
                if(sum - arr[j] >= 0 && dp[sum-arr[j]] != -2)
                    temp = dp[sum-arr[j]];
                else{
                    temp = minCoins(arr, dp,sum-arr[j]);
                    if(sum-arr[j] >= 0){
                        dp[sum-arr[j]] = temp;
                    }
                }
                if(temp < min && temp != -1){
                    min = temp;
                }
            }

            if(min == Integer.MAX_VALUE){
                return -1;
            }

            return min+1;
        }

        public static void main(String[] args) {
            int n = 3;
            int sum = 12;
            int[] arr = new int[n];
            arr[0] = 2;
            arr[1] = 5;
            arr[2] = 7;

            int[] dp = new int[sum];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = -2;
            }

            int min_sum = minCoins(arr, dp, sum);
            System.out.println(min_sum);
        }
    }
}
