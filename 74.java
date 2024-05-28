class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //先搜索第一列 找到target应该在的列
        int up =0;
        int down = m-1;
        int row = m-1;
        while(up<=down){
            int mid = (down+up)/2;
            // System.out.println("1: "+up+" "+down+" "+mid);
            if(matrix[mid][0]<=target){
                row = mid;
                up = mid+1;         
            }else{
                down = mid-1;
            }
        }

        int l=0;
        int r = n-1;
        while(l<=r){
            int mid = (r+l)/2;
            // System.out.println("2: "+mid);
            if(matrix[row][mid]>target){
                r = mid-1;
            }else if(matrix[row][mid]==target){
                return true;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}