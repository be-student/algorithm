package algorithm.leet208;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }

}

class Trie {

    private final HashSet<String> words = new HashSet<>();
    private final HashSet<String> prefixs = new HashSet<>();

    public Trie() {
    }

    public void insert(String word) {
        words.add(word);
        for (int i = 0; i < word.length(); i++) {
            prefixs.add(word.substring(0, i));
            System.out.println();
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        return prefixs.contains(prefix);
    }
}
