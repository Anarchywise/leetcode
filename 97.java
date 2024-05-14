class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if(m+n!=l){
            return false;
        }
        boolean dp[][] = new boolean[m+1][n+1];
        /*
         * dp[i][j] s1的前i个字符和s2的前j个字符能不能构成s3的前i+j个字符
         * dp[i][j] = dp[i-1][j]&&s1[i-1]==s3[i+j-1]||dp[i][j-1]&&s2[j-1]==s3[i+j-1]
         * vc
         */
        dp[0][0] = true;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i>0){
                    dp[i][j] = dp[i][j]||(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
                }
                if(j>0){
                    dp[i][j] = dp[i][j]||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                }
                
            }
        }

        return dp[m][n];
    }
}