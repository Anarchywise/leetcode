/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        is_in(root, p, q);
        return ans;
    }


    public boolean is_in(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return false;
        boolean left = is_in(root.left, p, q);
        boolean right = is_in(root.right, p, q);

        if(left&&right||((root.val==p.val||root.val==q.val)&&(left||right))){
            ans = root;
        }

        return left||right||(root.val==p.val||root.val==q.val);

    }
}