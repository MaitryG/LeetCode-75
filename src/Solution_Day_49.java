public class Solution_Day_49 {
    class Solution {
        public static int partition(int[] potions, int j, int r){
            int i;
            i = j-1;
            while(j<=r-1){
                if(potions[j]<potions[r]){
                    i = i+1;
                    int temp = potions[i];
                    potions[i] = potions[j];
                    potions[j] = temp;
                }
                j=j+1;
            }


            int temp = potions[i+1];
            potions[i+1] = potions[r];
            potions[r] = temp;

            return i+1;
        }
        public static void printArr(int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        public static void sort(int[] potions, int j, int r){
            if(j < r){
                int q = partition(potions, j, r);
                sort(potions, j, q-1);
                sort(potions, q+1, r);
            }
        }
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int[] pairs = new int[spells.length];
            sort(potions, 0, potions.length-1);

            // binSearch(0, potions.length, spells, potions, pairs, success);
            // for(int i = 0 ; i < spells.length; i++){
            //     for(int j = 0 ; j < potions.length; j++){
            //         long prod = (long)potions[j] * (long)spells[i];
            //         if(prod >= success){
            //             pairs[i] = pairs[i] + 1;
            //         }
            //     }
            // }
            int i = 0;
            for(int spell: spells){
                int indx  = potions.length;

                int l = 0;
                int r = potions.length-1;
                while(l<=r){
                    int mid = (l+r)/2;
                    long prod = (long)potions[mid] * (long)spell;
                    if(prod>=success){
                        r = mid-1;
                        indx = mid;
                    }else{
                        l = mid+1;
                    }
                }
                pairs[i] = potions.length - indx;
                i++;
            }



            return pairs;
        }
    }
}
