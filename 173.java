import java.util.ArrayList;
import java.util.List;

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
class BSTIterator {
    int now =-1;
    List<Integer> arrs;
    public BSTIterator(TreeNode root) {
        arrs = new ArrayList<>();
        in_order(root);
    }
    
    public int next() {
        now++;
        return arrs.get(now);
    }
    
    public boolean hasNext() {
        return now<arrs.size()-1;
        
    }

    public void in_order(TreeNode node){
        if(node==null){
            return;
        }
        in_order(node.left);
        arrs.add(node.val);
        in_order(node.right);
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */