import java.util.Arrays;

public class Solution_Day_2 {
        public int compress(char[] chars) {
            int group_length = 1;
            String s = "";

            if(chars.length == 1){
                return 1;
            }
            int i = 0;
            for(i = 0 ; i <= chars.length-2; i++){
                if(chars[i] == chars[i+1]){
                    group_length++;
                    continue;
                }

                if(group_length==1){
                    s += "" + chars[i];
                    group_length = 1;
                    continue;
                }
                s += "" + chars[i] + group_length;
                group_length = 1;
            }
            if(group_length!=1){
                s += "" + chars[i] + group_length;
            }else{
                s += "" + chars[i];
            }
            int j;
            for(j = 0 ; j < s.length(); j++){
                char c = s.charAt(j);
                chars[j] = c;
            }

            chars = Arrays.copyOfRange(chars,0,s.length());
            return chars.length;
        }
}

