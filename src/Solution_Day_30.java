import java.util.ArrayList;

public class Solution_Day_30 {

    //  Definition for a binary tree node.
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            // if(root1.val != root2.val){
            //     return false;
            // }

            ArrayList<Integer> results1 = new ArrayList<Integer>();
            ArrayList<Integer> results2 = new ArrayList<Integer>();

            class Traverse{
                Traverse(TreeNode curr, ArrayList<Integer> results){
                    if(curr.left != null){
                        new Traverse(curr.left, results);
                    }
                    if(curr.right != null){
                        new Traverse(curr.right, results);
                    }

                    if(curr.left == null && curr.right == null){
                        results.add(curr.val);
                    }
                }
            }

            new Traverse(root1, results1);
            new Traverse(root2, results2);

            return results1.equals(results2);
        }
    }
}
