public class Solution_Day_23 {
    class Solution {
        public boolean isPalindrome(int x) {
            String str = Integer.toString(x);
            String reverse_str = "";

            for(int i = str.length()-1 ; i >= 0; i--){
                reverse_str += str.charAt(i);
            }
            return reverse_str.equals(str);
        }
    }
}
