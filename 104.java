import java.util.Stack;


// public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
// }

//递归
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Integer.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int deep =0;
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.push(root);
        boolean is_one = true;
        while(!one.isEmpty()||!two.isEmpty()){
            if(is_one){
                TreeNode treeNode = one.pop();
                if(treeNode.left!=null)two.push(treeNode.left);
                if(treeNode.right!=null)two.push(treeNode.right);
                if(one.isEmpty()) {
                    is_one =false;
                    deep++;
                }
            }else{
                TreeNode treeNode = two.pop();
                if(treeNode.left!=null)one.push(treeNode.left);
                if(treeNode.right!=null)one.push(treeNode.right);
                if(two.isEmpty()) {
                    is_one =true;
                    deep++;
                }
            }
        }
        return deep;
    }
}