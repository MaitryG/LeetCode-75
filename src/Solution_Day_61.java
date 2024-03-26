public class Solution_Day_61 {
    class Solution {
        public String longestPalindrome(String s) {
            int max_length = 1;
            String max_str = s.substring(0,1);
            for(int i = 0 ; i < s.length(); i++){
                for(int j = i + max_length ; j <= s.length(); j++){
                    if(j-i > max_length && isPalindrome(s.substring(i,j))){
                        max_length = j-i;
                        max_str = s.substring(i,j);
                    }
                }
            }
            return max_str;
        }

        public boolean isPalindrome(String s){
            int left = 0;
            int right = s.length()-1;

            while(left<right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                right--;
                left++;
            }

            return true;
        }
    }
}
