class Solution {
    public int hammingWeight(int n) {
        int count =0;
        while(n!=0){
            //提取最低位
            int var = n&1;
            if(var == 1) count++;
            //n补零右移
            n = n>>>1;
        }
        return count;
    }
}