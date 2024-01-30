public class Solution_Day_6 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(target == matrix[i][j]){
                        return true;
                    }
                }
            }

            return false;
        }
}
