class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] ans = new boolean[]{false};
        int m =board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                doit(board, i, j, new boolean[m][n], word,0, ans);
                if(ans[0]) return true;
            }
        }
        return ans[0];
    }
    public void doit(char[][] board,int l,int r,boolean[][] visited,String word,int index,boolean[] ans){
        int m =board.length;
        int n = board[0].length;
        if(l<0||l>=m||r<0||r>=n) return;
        if(visited[l][r]) return;
        if(word.charAt(index)!=board[l][r]) return;
        if(index == word.length()-1){
            ans[0] = true;
            return;
        }
        visited[l][r] = true;
        doit(board,  l-1, r, visited, word,index+1, ans);
        doit(board,  l+1, r, visited, word,index+1,ans);
        doit(board, l, r-1, visited, word,index+1, ans);
        doit(board,l, r+1, visited, word,index+1, ans);
        visited[l][r] = false;
    
    }
}