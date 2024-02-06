public class Solution_Day_13 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int c = 0;
            for(int i = 0 ; i < flowerbed.length; i++){
                if(flowerbed[i] == 0){
                    boolean emptyleft = (i==0) || (flowerbed[i-1] == 0);
                    boolean emptyright = (i==flowerbed.length-1) || (flowerbed[i+1] == 0);

                    if(emptyleft && emptyright){
                        flowerbed[i] = 1;
                        c++;
                    }
                }
            }
            return c>=n;

        }

}
