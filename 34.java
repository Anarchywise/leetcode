
class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 ) return new int[]{-1,-1};
        int left = findL(nums, target);
        int right = findR(nums, target);
        //target不在 nums范围中 || target在范围中,但是不存在
        if(left == -1 || left>right){
            return new int[]{-1,-1};
        }
        return new int[]{left,right}; 
    }

    public int findL(int[] nums,int target){
        int ans = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]>=target){
                ans =mid;
                r =mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public int findR(int[] nums,int target){
        int ans = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<=target){
                ans =mid;
                l =mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}
