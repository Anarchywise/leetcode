
class TreeNode {
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
  public void flatten(TreeNode root) {
      getflatten(root);
  }
  public TreeNode getflatten(TreeNode root){
      if(root==null){
          return null;
      }
      TreeNode left = root.left;
      TreeNode right = root.right;
      if(left!=null&&right!=null){
          root.left=null;
          root.right = left;
          getflatten(left).right = right;
          return getflatten(right);
      }else if(left==null&&right!=null){
          return getflatten(right);
      }else if(right == null&&left!=null){
          root.left=null;
          root.right = left;
          return getflatten(left);
      }else{
          return root;
      }
  }
}