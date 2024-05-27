import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(new ArrayList<>(), candidates, target, 0, ans);
        return ans;
    }

    private void combine(List<Integer> prex, int[] candidates, int target, int start, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(prex));//必须创建新的
            return;
        }
        
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            prex.add(candidates[i]);
            combine(prex, candidates, target - candidates[i], i, ans); // 允许重复选择当前元素
            prex.remove(prex.size() - 1); // 回溯，移除最后一个元素
        }
    }
}
