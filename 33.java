class Solution {

    //二分查找 关键在于 根据中点相关的内容来判断向那边缩范围
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(target>nums[n-1]){
            //target 在分割点的左边
            int l =0;
            int r =n-1;
            while(l<r){
                int mid = (l+r)/2;
                if(nums[mid]<nums[n-1]){
                    r =mid-1;
                }else if(nums[mid]>target){
                    r= mid-1;
                }else if(nums[mid] == target){
                    return mid;
                }else{
                    l = mid+1;
                }
            }
            return nums[l] == target? l:-1;
        }else{
            //target 在分割点的you边
            int l =0;
            int r =n-1;
            while(l<r){
                int mid = (l+r)/2;
                if(nums[mid]>nums[n-1]){
                    l =mid+1;
                }else if(nums[mid]>target){
                    r= mid-1;
                }else if(nums[mid] == target){
                    return mid;
                }else{
                    l = mid+1;
                }
            }
            return nums[l] == target? l:-1;
        }
    }
}