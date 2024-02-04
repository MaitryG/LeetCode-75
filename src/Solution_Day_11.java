public class Solution_Day_11 {
    //CSES https://cses.fi/problemset/task/1633
    public class MaxNumberOfWays {

        public static int maxNumberOfWays(int n){
            if(n < 0){
                return 0;
            }
            if(n==0){
                return 1;
            }



            int[] dp = new int[n+1];
            for(int i = 0; i < dp.length; i++){
                dp[i] = -1;
            }
            if(dp[n] != -1){
                return dp[n];
            }



            dp[n] = 0;
            for(int j = 1; j <= 6; j++){
                dp[n] = dp[n] +  maxNumberOfWays(n-j);
            }
            return dp[n];
        }

        public static void main(String[] args) {
            System.out.println(maxNumberOfWays(3));
        }
    }

}
