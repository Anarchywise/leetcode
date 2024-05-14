class Solution {
    public int climbStairs(int n) {
        //dp[i] 代表走到第i个台阶要有多少方法
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int x=3;x<=n;x++){
            dp[x] = dp[x-1]+dp[x-2]+2;
        }

        return dp[n];
    }
}