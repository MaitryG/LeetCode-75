public class Solution_Day_72 {
    class Solution {
        public String makeGood(String s) {
            StringBuilder s1 = new StringBuilder(s);
            int i = 0;
            while(i < s1.length()-1){
                char a = s1.charAt(i);
                char b = s1.charAt(i+1);

                if(a - b == 32 || b - a == 32){
                    s1.delete(i, i+2);
                    if(i>0){
                        i--;
                    }
                }else{
                    i++;
                }
            }
            return s1.toString();

        }

    }
}
