import java.util.ArrayList;
import java.util.List;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //从最高位开始的连续1
        int count =0;
        while(left<right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<count;
    }
}