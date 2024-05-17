import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int left_size;
        int right_size;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        int root_position = map.get(preorder[0]);
        left_size = root_position;
        right_size = n-root_position-1;
        TreeNode root = new TreeNode(preorder[0]);
        int[] left_pre = new int[left_size];
        int[] left_in = new int[left_size];
        int[] right_pre = new int[right_size];
        int[] right_in = new int[right_size];

        left_pre = Arrays.copyOfRange(preorder,1, left_size+1);
        left_in = Arrays.copyOfRange(inorder,0, left_size);
        right_pre = Arrays.copyOfRange(preorder, left_size+1, left_size+right_size+1);
        right_in = Arrays.copyOfRange(inorder, left_size+1, left_size+right_size+1);

        if(left_size!=0) root.left = buildTree(left_pre, left_in);
        if(right_size!=0) root.right = buildTree(right_pre, right_in);
        return root;

    }
}