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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }
    public int maxSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int val = root.val;
        int left_max = Math.max(maxSum(root.left),0);
        int right_max = Math.max(maxSum(root.right),0);
        maxSum = Math.max(maxSum,val+left_max+right_max);
        return Math.max(left_max,right_max)+val;
    }
}