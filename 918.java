class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        //情况1 在中间找
        int max =Integer.MIN_VALUE; //最大值
        int max_end_to_i = nums[0];//在 i处结束的最大值
        int max_pre[] = new int[n+1]; //到i处的最大值(从0开始)
        int leftTotal = nums[0];
        max_pre[1] = nums[0];
        for(int i=2;i<=n;i++){ //从第二个开始
            leftTotal +=nums[i-1];
            max_end_to_i = Math.max(nums[i-1], max_end_to_i+nums[i-1]);
            max = Math.max(max, max_end_to_i);
            max_pre[i] = Math.max(max_pre[i-1], leftTotal);
        }

        //情况2  固定后缀,找最大前缀
        int max2 = nums[0];
        int rightTotal = 0;
        for(int i=n-1;i>0;i--){
            rightTotal +=nums[i]; 
            max2 = Math.max(max2, rightTotal+max_pre[i-1]);
        }
        return Math.max(max2, max);
    }
}