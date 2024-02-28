public class Solution_Day_35 {
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
        int max = 0;
        public void helper(TreeNode currNode, boolean isLeft, int length){
            if(currNode==null){return;}
            max = Math.max(length, max);
            if(isLeft){
                helper(currNode.right, false, length+1);
                helper(currNode.left, true, 1);
            }else{
                helper(currNode.left, true, length+1);
                helper(currNode.right, false, 1);
            }
        }
        public int longestZigZag(TreeNode root) {
            int count=0;

            helper(root.left, true, 1);
            helper(root.right, false, 1);
            return max;
        }
    }
}
