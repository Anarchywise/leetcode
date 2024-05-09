/*
 * 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int maxLength =0;
        for(int x : nums){
            if(!set.contains(x-1)){
                int currentNum = x;
                int maxL =1;
                while(set.contains(currentNum+1)){
                    currentNum+=1;
                    maxL+=1;
                }
                maxLength = Integer.max(maxL, maxLength);
            }
        }
        return maxLength;
    }
}

/*
 * 使用HashSet来减少查询下一个数字的复杂度
 * 搜索某个确定的值使用Set 和 Map很好用
 * Set和Map有contains方法
 */