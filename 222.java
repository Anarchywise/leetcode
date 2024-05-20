
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
    public int countNodes(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left = countHeight(root.left);
        int right = countHeight(root.right);
        if(left==right){
            return (int)Math.pow(2,left) + countNodes(root.right);
        }else{
            return (int)Math.pow(2,right) + countNodes(root.left);
        }
    }
    
    public int countHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(countHeight(node.left), countHeight(node.right))+1;
    }
}