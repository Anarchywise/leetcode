/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        int val = root.val;
        if(root.left==null&&root.right==null){
            return val == targetSum;
        }else if(root.left==null){
            return hasPathSum(root.right, targetSum-val);
        }else if(root.right==null){
            return hasPathSum(root.left, targetSum-val);
        }else{
            return hasPathSum(root.left, targetSum-val)||hasPathSum(root.right, targetSum-val);
        }


        
    }
}