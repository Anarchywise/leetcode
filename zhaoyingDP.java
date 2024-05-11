/*import java.util.*;

public static void main(String[] args) {
    int[] nums = {200,1};
    int[] values = {3,2};
    int n = nums.length;
    int[][] dp = new int[n][n];
    dp[0][0] = nums[0]*values[0];
    dp[0][n-1] = nums[n-1]*values[0];
    for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
            dp[i][j] = Integer.max(dp[i-1][(j+1)%n]+nums[j]*values[i],dp[i-1][j-1]+nums[j]*values[i]);
        }
    }
    Arrays.sort(dp[n-1]);
    System.out.println(dp[n-1][n-1]);
}
*/