class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        //最小值只能在右侧
        //旋转多次的结果和旋转一次的结果一样
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[r]){
                l = mid +1;
                System.out.println("l: " +l);
            }else{
                // mid可能是最小值
                r = mid;
                System.out.println("r: " +r);
            }
        }
        return nums[l];
    }
}