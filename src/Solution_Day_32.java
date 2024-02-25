public class Solution_Day_32 {
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
        int count = 0;
        public void dfs(TreeNode curr, int max){
            if(curr == null)return;
            if(curr.val >= max){
                max = curr.val;
                count++;
            }

            dfs(curr.left, max);
            dfs(curr.right, max);

        }

        public int goodNodes(TreeNode root) {
            int max = Integer.MIN_VALUE;
            dfs(root, max);
            return count;
        }
    }
}
