import java.util.ArrayList;
import java.util.List;

class Solution {
    int ans;
    List<Integer> list;
    public Solution(){
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;
    }
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        inOrder(root);
        int n = list.size();
        for(int i=0;i<n-1;i++){
            ans = Math.min(ans, list.get(i+1)-list.get(i));
        }
        return ans;
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