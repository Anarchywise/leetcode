import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return root.search(word);
    }
}

class Trie {
    Map<Character, Trie> childTries;
    boolean isEnd; // 表示该处是否为单词的结尾

    public Trie() {
        childTries = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.childTries.putIfAbsent(c, new Trie());
            node = node.childTries.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this);
    }

    private boolean searchHelper(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Trie child : node.childTries.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            if (node.childTries.containsKey(c)) {
                return searchHelper(word, index + 1, node.childTries.get(c));
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
