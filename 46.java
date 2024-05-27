import java.util.ArrayList;
import java.util.List;

class Solution {

    public void doit(List<Integer> prex, List<Integer> remind, List<List<Integer>> ans) {
        if (remind.size() == 0) {
            ans.add(new ArrayList<>(prex)); // 创建一个新的列表添加到结果中
            return;
        }
        //前缀 ==> 
        //接下来要遍历的 ==> remind里的
        //结束条件 ==> 剩下的为0 
        for (int i = 0; i < remind.size(); i++) {
            int num = remind.get(i);
            prex.add(num);
            List<Integer> newRemind = new ArrayList<>(remind);
            newRemind.remove(i);
            doit(prex, newRemind, ans);
            prex.remove(prex.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> remind = new ArrayList<>();
        for (int num : nums) {
            remind.add(num);
        }
        doit(new ArrayList<>(), remind, ans);
        return ans;
    }
}
