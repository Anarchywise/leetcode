import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length+1];
        int a = 0;
        for(int i =digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //处理都是9的情况
        ans[0] =1;
        return ans;
    }
}