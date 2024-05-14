class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = grid[0][0];
        for(int x=1;x<=m;x++){
            for(int xx=1;xx<=n;xx++){
                if(x==1){
                    dp[x][xx] = dp[x][xx-1]+grid[x-1][xx-1];
                }else if(xx==1){
                    dp[x][xx] = dp[x-1][xx]+grid[x-1][xx-1];
                }else{
                    dp[x][xx]= Integer.min(dp[x][xx-1],dp[x-1][xx])+grid[x-1][xx-1];
                }
            }
        }
        for(int[] row:dp ){
            for(int i:row){
                System.out.print(i+"");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}