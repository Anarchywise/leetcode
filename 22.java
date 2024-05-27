class Solution {
    StringBuffer path = new StringBuffer(); //prex
    List<String> res = new ArrayList<>();
 
    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }
    //回溯法
    /*
     * 下一个添加的不是"("就是")"
     */
    // () 要遍历的数据

    void backtracking(int l, int r, int n) {
        if (l > n || l < r) { // 剪枝
            return;
        }
        if (l== r && l == n) { // 成立条件
            res.add(path.toString());
        }
        for (int i = 0; i < 2; i++) { // 将括号看作大小为 2 的数组，求他们的有效组合，括号个数决定了树的深度
            if (i == 0) {
                path.append("(");
                backtracking(l + 1, r, n); //遍历左括号l+1个  有括号r个的情况
                path.deleteCharAt(path.length() - 1); // 回溯
            }
            if (i == 1) {
                path.append(")");
                backtracking(l, r + 1, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
        }
    }
 }