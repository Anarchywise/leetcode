class Solution {
    //爬坡,随机从一个位置开始,根据位置的左右两侧来确定那边有坡 O(n)
    //遍历一遍,找到最大值  O(n)
    //爬坡的优化 二分查找 根据mid的左右两侧确定哪里有峰值(向左右那边继续查找)
    public int findPeakElement(int[] nums) {
        int l =0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(compare(nums, mid, mid-1)>0&&compare(nums, mid, mid+1)>0){
                //峰值
                return mid;
            }else if(compare(nums, mid, mid-1)>0&&compare(nums, mid, mid+1)<0){
                //mid-1<mid<mid+1
                l = mid+1;
            }else{
                //mid-1>mid>mid+1
                // mid-1>mid<mid+1
                r = mid-1;
            }
        }
        return l;
        
    }
    public int[] getVal(int[] nums,int dx){
        if(dx==-1||dx==nums.length){
            return new int[]{0,0}; 
        }
        return new int[]{1,nums[dx]};
    }
    public int compare(int[] nums,int dx1,int dx2){
        int[] val1 = getVal(nums, dx1);
        int[] val2 = getVal(nums, dx2);
        if(val1[0]!=val2[0]){
            return val1[0]>val2[0]? 1:-1;
        }
        return val1[1]-val2[1];
    }
}