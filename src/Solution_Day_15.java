import java.util.Arrays;
import java.util.Scanner;

public class Solution_Day_15 {

    public class WordConnector {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            String[] s1 = s.toLowerCase().split("\\|");

            int[] used = new int[s1.length];
//        for (int i = 0; i < used.length; i++) {
//            used[i] = -1;
//        }
            used[0] = -1;
            String x = mygetString(s1, s1[0], used);

        }

        private static String mygetString(String[] s1, String str, int[] used) {
            System.out.println(str);
            StringBuilder sb = new StringBuilder(str);

            for (int i = 0; i < s1.length; i++) {
                if(s1[i].charAt(0) == str.charAt(str.length()-1) && (used[i] == 0)){
                    used[i] = -1;
                    String temp = mygetString(s1, s1[i], used);
                    System.out.println(temp);
                    if(temp.equals("-1")){
                        used[i] = 0;
                    }else {
                        return sb.append(" ").append(temp).toString();
                    }
                }
            }

            if(checkIfAllUsed(used)){
                return sb.toString();
            }else {
                return "-1";
            }
        }

        private static boolean checkIfAllUsed(int[] used){

            System.out.println(Arrays.toString(used));

            for(int i : used){
                if(i == 0){
                    return false;
                }
            }

            return true;
        }

    }

}
