import java.util.ArrayList;
import java.util.List;

public class Solution_Day_67 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            // int[] arr = new int[s.length()];
            List<Integer> arr = new ArrayList<>();
            if(s.length()< p.length()){
                return arr;
            }
            for(int i = 0 ; i <= s.length()-p.length(); i++){
                String s1 = s.substring(i, i+p.length());
                if(isAnagram(s1,p)){
                    arr.add(i);
                }
            }

            return arr;
        }

        public boolean isAnagram(String s1, String s2){
            int[] chars = new int[26];
            for(char curr : s1.toCharArray()){
                int z = curr - 'a';
                chars[z]++;
            }
            for (char current : s2.toCharArray()) {
                chars[current - 'a']--;
            }
            for (int current : chars) {
                if (current != 0) {
                    return false;
                }
            }
            return true;

        }
    }
}
