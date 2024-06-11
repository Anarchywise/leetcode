class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left[] = new int[n+1];
        int right[] = new int[n+1];
        int minA =prices[0];
        int maxA =Integer.MIN_VALUE+1;
        left[1] = 0;
        for(int i=2;i<=n;i++){
            minA = Math.min(minA, prices[i-1]);
            maxA = Math.max(maxA, (prices[i-1]-minA));
            left[i] = maxA;
            System.out.println("L i: "+i +"==> "+left[i]);
        }
        int maxB = prices[n-1]; // 最高点
        int maxmaxB = 0;
        right[n] = 0;
        for(int i=n-1;i>0;i--){
            maxB = Math.max(maxB, prices[i-1]);
            maxmaxB = Math.max(maxmaxB, (maxB-prices[i-1]));
            right[i] = maxmaxB;
            System.out.println("R i: "+i +"==> "+right[i]);
        }
        int ans =0;
        for(int i =1;i<=n;i++){
            ans = Math.max(ans, left[i]+right[i]);
        }
        return ans;
    }
}