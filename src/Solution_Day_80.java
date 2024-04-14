public class Solution_Day_80 {
    class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            if(s.length()==1){return 1;}
            int i = s.length()-1;
            int c = 0;
            while(i!=-1 && s.charAt(i) != ' '){
                i--;
                c++;
                // if(i==0){
                //     return c;
                // }
            }

            return c;

        }
    }
}
