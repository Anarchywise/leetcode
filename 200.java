class Solution {
    public int numIslands(char[][] grid) {
        int num =0;
        for(int i=0;i<grid.length;i++){
            for(int ii=0;ii<grid[0].length;ii++){
                if(grid[i][ii]=='1'){
                    dfs(grid, i, ii);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid,int r,int l){
        if(!inArea(grid, r, l)){
            return;
        }
        if(grid[r][l]!='1'){
            return;
        }
        grid[r][l] ='2';
        dfs(grid, r-1, l);
        dfs(grid, r+1, l);
        dfs(grid, r, l-1);
        dfs(grid, r, l+1);
    }

    public boolean inArea(char[][] grid,int r,int l){
        return r>=0&&r<grid.length&&
                l>=0&&l<grid[0].length;
    }
}