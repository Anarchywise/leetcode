import java.util.HashMap;

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

 // Map提取出来重复使用

class Solution {

    private Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder, postorder,0,n-1,0,n-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int in_s,int in_e,int post_s,int post_e) {
        System.out.print("in_s:"+in_s+" in_e:"+in_e+" post_s:"+post_s+" post_e:"+post_e);
        System.out.println();
        int root_in_p = map.get(postorder[post_e]);
        TreeNode root = new TreeNode(postorder[post_e]);
        int left_in_e_next = root_in_p-1;
        int right_in_s_next = root_in_p+1;
        int left_post_e_next = post_s+root_in_p-in_s-1;
        int right_post_s_next = left_post_e_next+1;
        System.out.print("left===="+"in_s:"+in_s+" in_e:"+left_in_e_next+" post_s:"+post_s+" post_e:"+left_post_e_next);
        System.out.println();
        System.out.print("right===="+"in_s:"+right_in_s_next+" in_e:"+in_e+" post_s:"+right_post_s_next+" post_e:"+(post_e-1));
        System.out.println();
        if(root_in_p-in_s>0) root.left = buildTree(inorder, postorder,in_s,left_in_e_next,post_s,left_post_e_next);
        if(in_e-root_in_p>0) root.right = buildTree(inorder, postorder,right_in_s_next,in_e,right_post_s_next,post_e-1);
        return root;
    }
}

/*
 * import java.util.HashMap;
import java.util.Map;

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
class Solution {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // Initialize the map to store the index of each value in inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int in_s, int in_e, int post_s, int post_e) {
        if (in_s > in_e || post_s > post_e) {
            return null;
        }

        // Get the root value from the end of postorder segment
        int rootVal = postorder[post_e];
        TreeNode root = new TreeNode(rootVal);

        // Get the root index in inorder array
        int root_in_p = inorderIndexMap.get(rootVal);

        // Calculate the number of nodes in left subtree
        int leftTreeSize = root_in_p - in_s;

        // Recursively build the left and right subtrees
        root.left = buildTree(inorder, postorder, in_s, root_in_p - 1, post_s, post_s + leftTreeSize - 1);
        root.right = buildTree(inorder, postorder, root_in_p + 1, in_e, post_s + leftTreeSize, post_e - 1);

        return root;
    }
}

 */