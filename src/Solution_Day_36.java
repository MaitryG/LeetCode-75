import java.util.ArrayList;
import java.util.List;

public class Solution_Day_36 {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> results = new ArrayList<>();
            int max=-1;
            for(int i = 0; i < candies.length; i++){
                if(candies[i]>max){
                    max=candies[i];
                }
            }

            for(int j = 0; j < candies.length; j++){
                if(candies[j] + extraCandies >= max){
                    results.add(true);
                }else{
                    results.add(false);
                }
            }

            return results;
        }
    }
}
