class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        int left = 1, right = x;
        int ans = 0;

        // 使用二分法寻找平方根
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {  // 使用long类型避免溢出
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}
