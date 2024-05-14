class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Integer.max(nums[0],nums[1]);
        }
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];
        for(int x = 3;x<=nums.length;x++){
            dp[x] = Integer.max(Integer.max(dp[x-2]+nums[x], dp[x-1]),dp[x-3]);
        }

        return dp[nums.length];
    }
}