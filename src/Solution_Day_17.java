import java.util.ArrayList;

public class Solution_Day_17 {
    class Solution {
        public String removeStars(String s) {
            ArrayList<Character> al = new ArrayList<Character>();


            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == '*'){
                    //pop a letter from stack
                    al.remove(al.size()-1);
                }else{
                    //add the character onto the stack
                    al.add(s.charAt(i));
                }
            }

            String s1 = "";
            for(int k = 0 ; k < al.size(); k++){
                s1 = s1 + al.get(k);
            }

            return s1;

        }
    }
}
