

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int x=0;x<dp.length;x++){
            dp[x] =Integer.MAX_VALUE;
        }
        dp[0] =0;
        for(int x=1;x<=amount;x++){
            int min = Integer.MAX_VALUE;
            for(int i=coins.length-1;i>=0;i--){
                if(x-coins[i]>=0){
                    if(!(dp[x-coins[i]]==Integer.MAX_VALUE)){  
                        min = Integer.min(dp[x-coins[i]]+1,min);
                    }
                }
            }
            dp[x] = min;
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}