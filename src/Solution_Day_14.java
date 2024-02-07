import java.util.Scanner;

import java.util.Scanner;


public class Solution_Day_14 {
    public class SetMatrixZero {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int[][] arr = new int[3][4];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    String s = sc.next();
                    arr[i][j] = Integer.valueOf(s);
                }
            }
            arr = setZeroes(arr);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }

        private static int[][] setZeroes(int[][] arr) {
            int flag_row = 0;
            int flag_col = 0;
            int col0=1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 0){
                        arr[i][0] = 0;
                        if(j!=0){
                            arr[0][j] = 0;
                        }else{
                            col0 = 0;
                        }
                    }
                }
            }

            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[i].length ; j++) {
                    if(arr[i][0] == 0 || arr[0][j] == 0){
                        arr[i][j] = 0;
                    }
                }
            }

            if(arr[0][0] == 0){
                for (int i = 0; i < arr[0].length; i++) {
                    arr[i][0] = 0;
                }
            }

            if(col0 == 0){
                for (int i = 0; i < arr.length; i++) {
                    arr[0][i] = 0;
                }
            }
            return arr;
        }

    }

}
