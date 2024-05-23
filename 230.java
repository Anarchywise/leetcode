import java.util.ArrayList;
import java.util.List;

class Solution {
    int ans;
    List<Integer> list;
    public Solution(){
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        inOrder(root);
        return list.get(k-1);
    }

    public void inOrder(TreeNode root){
        if(root ==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}