import java.util.ArrayList;

public class Solution_Day_34 {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        int total = 0;
        public void helper(TreeNode t, int count, int sum){
            if(t==null){return;}
            if(count+t.val == sum){
                total++;
            }
            helper(t.left, count+t.val, sum);
            helper(t.right, count+t.val, sum);

        }
        public int pathSum(TreeNode root, int targetSum) {
            ArrayList<Integer> results = new ArrayList<>();
            if(root==null){
                return 0;
            }
            class Traverse{
                Traverse(TreeNode currentNode){
                    helper(currentNode, 0, targetSum);

                    if(currentNode.left != null){
                        new Traverse(currentNode.left);
                    }
                    if(currentNode.right != null){
                        new Traverse(currentNode.right);
                    }
                }
            }

            new Traverse(root);
            // return results;
            return total;
        }
    }
}
