import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int n = stack.size();
            double sum =0;
            for(int i=0;i<n;i++){
                TreeNode treeNode =stack.poll();
                sum+=(double)treeNode.val;
                if(treeNode.left!=null) stack.add(treeNode.left);
                if(treeNode.right!=null) stack.add(treeNode.right);
            }
            ans.add(sum/n);
        }
        return ans;
    }
}