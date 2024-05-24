class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if(n<=2&&m<=2){
            return;
        }
        //边界'0'替换为'R'
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
        }
        for(int i=1;i<n;i++){
            if(board[i][m-1]=='O'){
                dfs(board, i, m-1);
            }
        }
        for(int i=1;i<m;i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i);
            }
        }
        for(int i=1;i<m;i++){
            if(board[n-1][i]=='O'){
                dfs(board, n-1, i);
            }
        }
        //扫描一遍'0' 替换为'X','R'替换为'0'
        for(int i=0;i<n;i++){
            for(int ii=0;ii<m;ii++){
                if(board[i][ii]=='O'){
                    board[i][ii]='X';
                }else if(board[i][ii]=='R'){
                    board[i][ii]='O';
                }
            }
        }


    }

    public void dfs(char[][] board,int r,int l){
        if(!inArea(board, r, l)){
            return;
        }
        if(board[r][l]!='O'){
            return;
        }
        board[r][l] = 'R';
        dfs(board, r-1, l);
        dfs(board, r+1, l);
        dfs(board, r, l-1);
        dfs(board, r, l+1);
    }

    public boolean inArea(char[][] board,int r,int l){
        return r>=0&&r<board.length&&
                l>=0&& l<board[0].length;
    }
}