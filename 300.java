import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);
        for(int x=1;x<=nums.length;x++){
            for(int i=1;i<x;i++){
                if(nums[x-1]>nums[i-1]){
                    dp[x] = Integer.max(dp[i]+1,dp[x]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[nums.length];
    }
}