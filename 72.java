class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j] word1的前 i 个和word2 的前 j 个的编辑距离
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        //
        if(m*n==0){
            return m==0? n:m;
        }

        //
        for(int i=1;i<=n;i++){
            dp[i][0] = i;
        }

        for(int i=1;i<=m;i++){
            dp[0][i] = i;
        }

        //

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int a = dp[i-1][j]+1;
                int b = dp[i][j-1]+1;
                int c = dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    c++;
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }

        return dp[n][m];

    }
}