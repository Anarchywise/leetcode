public class Solution {
    // you need treat n as an unsigned value
    int ans = 0;
    public int reverseBits(int n) {
       //提取最低位
       //ans 得到
       for(int i=0;i<32;i++){
        //提取最低位
        int var = (n&1);
        //n按位右移补零
        n = n>>>1;
        //将提取到的位 填入ans
        ans|=var<<(31-i);
       }
       return ans;
    }
}