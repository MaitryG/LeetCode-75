public class Solution_Day_62 {
    class Solution {
        public int reverse(int x) {
            String s = Integer.toString(x);
            int k = 0;
            int num = 0;
            if(s.charAt(0) == '-'){
                s = s.substring(1);
                int y = 0;
                while(k<s.length()){
                    y = s.charAt(k) - '0';
                    num += y * Math.pow(10,k);
                    k++;
                }
                if(num >= Math.pow(2,31) - 1 || num <= -Math.pow(2,31)){
                    return 0;
                }
                return -num;
            }else{
                int y = 0;
                while(k<s.length()){
                    y = s.charAt(k) - '0';
                    num += y * Math.pow(10,k);
                    k++;
                }
                if(num >= Math.pow(2,31) - 1 || num <= -Math.pow(2,31)){
                    return 0;
                }
                return num;

            }


        }
    }
}
