class Solution {
    public double myPow(double x, int n) {
        if(n ==0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        return n>0? get(x, n) : 1/get(x, n);
    }
    
    public double get(double x,int n){
        if(n == 0){
            return 1.0;
        }
        double y = get(x, n/2);
        return n%2==0? y*y : y*y*x;
    }
}