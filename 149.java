class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length; int ans =0;
        if(n<=2){
            return n;
        }
        for(int i=0;i<n;i++){
            int[] x = points[i];
            for(int j=i+1;j<n;j++){
                int[] y = points[j];
                int cnt =2;
                for(int k =j+1;k<n;k++){
                    int[] p = points[k];
                    int s1 = (y[1]-x[1])*(p[0]-x[0]);
                    int s2 = (y[0]-x[0])*(p[1]-x[1]);
                    if(s1==s2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}