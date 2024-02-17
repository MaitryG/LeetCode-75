import java.util.Stack;

public class Solution_Day_24 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for(int i = 0 ; i < asteroids.length; i++){
                if(stack.isEmpty() || asteroids[i] > 0){
                    stack.add(asteroids[i]);
                }else{
                    while(true){
                        int num = stack.peek();
                        if(num < 0){
                            stack.add(asteroids[i]);
                            break;
                        }else if(num == -asteroids[i]){
                            stack.pop();
                            break;
                        }else if(num > -asteroids[i]){
                            break;
                        }else{
                            stack.pop();
                            if(stack.isEmpty()){
                                stack.add(asteroids[i]);
                                break;
                            }
                        }
                    }
                }
            }

            int[] ans = new int[stack.size()];
            for(int i = stack.size() - 1 ; i >= 0; i--){
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
