import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root == null){
            return ans;
        }
        stack1.push(root);
        boolean is_left_to_right = false;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n=0;
            if(is_left_to_right){
                n = stack2.size();
            }else{
                n = stack1.size();
            }
            for(int i=0;i<n;i++){
                if(is_left_to_right){
                    TreeNode treeNode = stack2.pop();
                    list.add(treeNode.val);
                    if(treeNode.right!=null) stack1.add(treeNode.right);
                    if(treeNode.left!=null) stack1.add(treeNode.left);
                }else{
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if(treeNode.left!=null) stack2.add(treeNode.left);
                    if(treeNode.right!=null) stack2.add(treeNode.right);
                }   
            }
            is_left_to_right = !is_left_to_right;
            ans.add(list);
        }
        return ans;
    }
}
