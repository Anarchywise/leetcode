import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        doit(new ArrayList<>(), 1, n, k, ans);
        return ans;
    }

    public void doit(List<Integer> prex, int start, int n, int k, List<List<Integer>> ans) {
        if (prex.size() == k) {
            ans.add(new ArrayList<>(prex)); // 创建一个新的列表添加到结果中
            return;
        }

        for (int i = start; i <= n; i++) {
            prex.add(i);
            doit(prex, i + 1, n, k, ans); // 从 i + 1 开始，避免重复
            prex.remove(prex.size() - 1); // 回溯，移除最后一个元素
            // remove(Object o)
            // remove(Integer index) 先匹配Integer
        }
    }
}
