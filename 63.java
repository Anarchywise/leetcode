class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        dp[1][0]=1;
        for(int i=1;i<=m;i++){
            for(int ii=1;ii<=n;ii++){
                if(obstacleGrid[i-1][ii-1]==1){
                    dp[i][ii]=0;
                }else if(i==1){
                    dp[i][ii] = dp[i][ii-1];
                }else if(ii==1){
                    dp[i][ii] = dp[i-1][ii];
                }else{
                    dp[i][ii] = dp[i-1][ii]+dp[i][ii-1];
                }
            }
        }
        return dp[m][n];
    }
}