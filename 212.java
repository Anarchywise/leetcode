import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Stream.of(words).forEach(trie::insert);
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].length()>maxLen){
                maxLen = words[i].length();
            }
        }
        int m = board.length;
        int n = board[0].length;
        Set<String> ans = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int ii=0;ii<n;ii++){
                boolean visited[][] = new boolean[m][n];
                dfs(board, visited, i, ii, "", trie, maxLen, ans);
            }
        }
        return new ArrayList<>(ans);
    }
    public void dfs(char[][] board,boolean[][] visited,int m,int n,String prex,Trie trie,int maxLen,Set<String> ans){
        if(m<0||m>=board.length||n<0||n>=board[0].length) return; //超出

        if(visited[m][n]) return; //已遍历过

        String now = prex + board[m][n]; //现在的单词

        if(!trie.startsWith(prex)) return;//前缀不在Trie中

        if(trie.search(now)) ans.add(now);

        visited[m][n] = true; //标记已遍历过
        
        if(now.length()<maxLen){
            dfs(board,visited,m-1, n, now, trie, maxLen, ans);
            dfs(board,visited,m+1, n, now, trie, maxLen, ans);
            dfs(board,visited,m, n-1, now, trie, maxLen, ans);
            dfs(board,visited,m, n+1, now, trie, maxLen, ans);
        }
        visited[m][n] = false; // 回溯时清除标记
    }

    class Trie {
        Trie[] childTries;
        boolean isEnd; // 在这里结束有个单词
        public Trie() {
            childTries = new Trie[26];
            isEnd =false;
        }
        
        public void insert(String word) {
            Trie node = this;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(node.childTries[index] == null){
                    node.childTries[index] = new Trie();
                }
                node = node.childTries[index];
            }
            node.isEnd = true;
        }
        
        public boolean search(String word) {
            Trie node = this;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(node.childTries[index]==null){
                    return false;
                }else{
                    node = node.childTries[index];
                }
            }
            return node.isEnd;
        }
        
        public boolean startsWith(String prefix) {
            Trie node = this;
            for(int i=0;i<prefix.length();i++){
                int index = prefix.charAt(i)-'a';
                if(node.childTries[index]==null){
                    return false;
                }else{
                    node = node.childTries[index];
                }
            }
            return true;
        }
    }
}
