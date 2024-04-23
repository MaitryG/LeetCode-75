import java.util.ArrayList;
import java.util.List;

public class Solution_Day_89 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> arr = new ArrayList<>();
            if(root==null){
                return arr;
            }
            class Traverse{
                Traverse(TreeNode node){
                    if(node.left!=null){
                        new Traverse(node.left);
                    }

                    arr.add(node.val);

                    if(node.right!=null){
                        new Traverse(node.right);
                    }
                }


            }

            new Traverse(root);
            return arr;
        }
    }
}
