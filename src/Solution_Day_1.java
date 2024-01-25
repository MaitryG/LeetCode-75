public class Solution_Day_1 {
    public String reverseWords(String s) {
        String rev = s.trim();

        String[] arr = rev.split("\\s+"); //Regex for removing two or more spaces
        rev = "";

        for(int i = arr.length-1; i>=0; i--){
            rev = rev + arr[i] + " ";
        }
        System.out.println();

        return rev.trim();
    }
}
