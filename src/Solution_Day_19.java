public class Solution_Day_19 {
        public int maxVowels(String s, int k) {
            int count = 0;
            int max = 0;

            for(int i = 0; i < k; i++){
                if(isvowel(s.charAt(i))){
                    count++;
                }
            }
            max = count;
            for(int i = k ; i < s.length(); i++){
                if(isvowel(s.charAt(i))){
                    count++;
                }
                if(isvowel(s.charAt(i-k))){
                    count--;
                }
                max = Math.max(max, count);
            }

            return max;
        }

        public boolean isvowel(char c){
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }

//My solution with 100/109 testcases passed but TLE error
// class Solution {
//     public int maxVowels(String s, int k) {
//         int count = 0;
//         int max = Integer.MIN_VALUE;
//         for(int i = 0 ; i < s.length()-k+1; i++){
//             String sub = s.substring(i, i+k);
//             for(int j = 0; j < sub.length(); j++){
//                 if(sub.charAt(j) == 'a' || sub.charAt(j) == 'e' || sub.charAt(j) == 'i' || sub.charAt(j) == 'o' || sub.charAt(j) == 'u'){
//                     count++;
//                 }
//             }
//             max = Math.max(count, max);
//             count = 0;
//         }

//         return max;
//     }
// }
