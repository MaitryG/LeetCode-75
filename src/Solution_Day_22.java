import java.util.Stack;

public class Solution_Day_22 {

    public class Main {
        public static boolean isBalancedParentheses(String str){
            Stack s = new Stack();
            if(str.equals("")){
                return false;
            }
            if(str.length() == 1 || str.charAt(0) == ')'){
                return false;
            }
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i)=='('){
                    s.push(str.charAt(i));
                }else if(str.charAt(i) ==')' && !s.isEmpty() && s.peek().equals('(')){
                    s.pop();
                }else if(str.charAt(i)==')' && s.isEmpty() || !s.peek().equals('(')){
                    return false;
                }
            }

            if(s.isEmpty()){
                return true;

            }else{
                return false;
            }


        }



        public static void main(String[] args) {
            testAndPrint("()", true);
            testAndPrint("()()", true);
            testAndPrint("(())", true);
            testAndPrint("()()()", true);
            testAndPrint("(()())", true);
            testAndPrint(")()(", false);
            testAndPrint(")(", false);
            testAndPrint("(()", false);
            testAndPrint("))", false);
            testAndPrint("(", false);
            testAndPrint(")", false);
        }

        public static void testAndPrint(String testStr, boolean expected) {
            // Run the test and store the result
            boolean result = isBalancedParentheses(testStr);

            // Print the test string, expected result, and actual result
            System.out.println("Test String: " + testStr);
            System.out.println("EXPECTED: " + expected);
            System.out.println("RESULT: " + result);

            // Check if the test passed or failed
            if (result == expected) {
                System.out.println("STATUS: PASS");
            } else {
                System.out.println("STATUS: FAIL");
            }

            // Print a separator for better readability
            System.out.println("--------------");
        }

    }

}
