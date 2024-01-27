import java.util.Arrays;

public class Solution_Day_3 {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }

            int[] freq1 = new int[26]; //Creating for storing frequencies of a-z in word 1
            int[] freq2 = new int[26]; //Same for word 2

            for (int i = 0; i < word1.length(); i++) {
                freq1[word1.charAt(i) - 'a']++; //Calculating frequencies for each letter in word 1
            }
            for (int j = 0; j < word2.length(); j++) {
                freq2[word2.charAt(j) - 'a']++; //Same for word 2

            }
            for (int i = 0; i < freq1.length; i++) {
                if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                    return false; //Return false if one of the letter doesnt exist in the other word
                    //For example letter 'u' might be 0 in word1 but present in word 2. In such a case we
                    //can never reach word2.
                }
            }

            Arrays.sort(freq1); //Now sorting the arrays to just see if the frequencies are equal
            Arrays.sort(freq2); //If they are equal, it means we can perform some operations and get to word2 from word1

            for (int k = 0; k < freq1.length; k++) {
                if (freq1[k] != freq2[k]) {
                    return false;
                }
            }

            return true;


        }
}
