import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }        
        //填充问题,不要用dp[0]取填充dp,因为传对象,会导致dp[i]的引用都是dp[0]
        dp[1][1] =triangle.get(0).get(0);
        for(int i=2;i<=n;i++){
            for(int ii=1;ii<=i;ii++){
                if(ii==1){
                    dp[i][ii] = dp[i-1][ii]+triangle.get(i-1).get(ii-1);
                }else if(ii==i){
                    dp[i][ii] = dp[i-1][ii-1]+triangle.get(i-1).get(ii-1);
                }else{
                    dp[i][ii] = Integer.min(dp[i-1][ii], dp[i-1][ii-1])+triangle.get(i-1).get(ii-1);
                }  
            }
        }
        Arrays.sort(dp[n]);
        return dp[n][n];
    }
}