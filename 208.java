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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */