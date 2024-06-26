import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_Day_68 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<HashMap<Character,Integer>> list  = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            for(int i = 0 ; i < strs.length; i++){
                HashMap<Character, Integer> h = createMap(strs[i]);
                // print(h);
                if(list.contains(h)){
                    // System.out.println(strs[i]);
                    int indx = list.indexOf(h);
                    //System.out.println(strs[i] + " " + indx);
                    List<String> tmp = res.get(indx);
                    tmp.add(strs[i]);
                    // res.add(tmp);
                }else{
                    list.add(h);
                    List<String> tmp = new ArrayList<>();
                    tmp.add(strs[i]);
                    res.add(tmp);
                }
            }
            return res;

        }

        public void print(HashMap<Character, Integer> h){
            for(char c: h.keySet()){
                System.out.println(h.get(c));
            }
        }

        public HashMap<Character,Integer> createMap(String s){
            HashMap<Character,Integer> h = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                int c = h.getOrDefault(s.charAt(i), 0) + 1;
                if(c==0){
                    h.put(s.charAt(i), c);
                }else{
                    System.out.println(c);
                    h.put(s.charAt(i), c++);
                }
            }
            return h;
        }
    }
}
