class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int max = nums[0];
        int max_end_to_i = nums[0];
        for(int i=1;i<n;i++){ //从第二个开始
            max_end_to_i = Math.max(nums[i], max_end_to_i+nums[i]);
            max = Math.max(max, max_end_to_i);
        }
        return max;
    }
}