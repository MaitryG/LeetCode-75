//Bleep the words given to bleep.

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Solution_Day_18 {

    public class Lab2StringBleep {
        public static void main(String[] args) {
            String s = "hello world,orange garbage cool! new this shit; col akldsn scdaubn! fuck! vffdsvf garbage";
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++){
                words[i] = sc.next();
            }
//        String s1="";
//        String words1[] = new String[s.length()];
//        for(int j = 0; j < s.length(); j++){
//            if (s.charAt(j) != ' '){
//                s1 = s1 + s.charAt(j);
//            }else{
//                System.out.println(s1);
//                words1[j] = s1;
//                s1 = "";
//            }
//        }
            String dialogues[] = new String[s.length()];
            Arrays.fill(dialogues, "");
            int m = 0;
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) != '!' && s.charAt(i) != ';' && s.charAt(i) != ',') {
                    dialogues[m] += (s.charAt(i));
                    continue;
                }
                m++;
            }
            int count=0;
            for(int i = 0 ; i < dialogues.length; i++){
                for(int j = 0 ; j < words.length; j++){
                    //compare
                    StringBuilder s1 = new StringBuilder(dialogues[i]);
                    if(s1.toString().contains(words[j])){
                        int starindx = dialogues[i].indexOf(words[j]);
                        int endindx = starindx + words[j].length();
                        for(int l = starindx+1; l < endindx; l++){
                            s1.setCharAt(l, '*');
                        }
                        count++;
                    }
                    dialogues[i] = s1.toString();
                }
            }
            for (int i = 0; i < dialogues.length; i++) {
                if(!dialogues[i].equals("")){
                    System.out.println(dialogues[i].trim());
                }
            }
            System.out.println("Number of words beeped: " + count);
        }
    }

}
