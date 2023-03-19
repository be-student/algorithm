package algorithm.leet211;

public class Solution {

    public static void main(String[] args) {

        //["WordDictionary","addWord","addWord","addWord","search","search","addWord","search","addWord","search","addWord","addWord","search","addWord","addWord","search","search","addWord","addWord","search","search","search","addWord","search","addWord","addWord"
        //[[],["xgvk"],["wykzbvwdsoyfowqicymzd"],["xajbtjyjuwgoynjgu"],["wykzbvwdso..owqicymzd"],["..ha"],["qsibzxaorktypkfg"],["xgvk"],["vbycuvrkbcq"],["qsibz.aorkty.kfg"],["sm"],["fkqclfmvzpzpnbvz"],["vb..uvrkbcq"],["jpnneostllnnma"],["zvmtfg"],[".g.."],[".kqclfmvzpzpnbvz"],["lboe"],["jypzkxnzc"],["ii..mhdgrif"],["ln."],["zv..fg"],["qes"],["ittu.ggead.lxjey.i"],["jioqlytzqx"],["fojsjyiz"],["a"],["qkprluekewtsftvbrjndpt"],["fkq.lfmvzp.p.bvz"],
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("xgvk");
        wordDictionary.addWord("wykzbvwdsoyfowqicymzd");
//        wordDictionary.addWord("xajbtjyjuwgoynjgu");
//        System.out.println(wordDictionary.search("wykzbvwdso..owqicymzd"));
//        System.out.println(wordDictionary.search("..ha"));
//        wordDictionary.addWord("qsibzxaorktypkfg");
//        System.out.println(wordDictionary.search("xgvk"));
//        wordDictionary.addWord("vbycuvrkbcq");
//        System.out.println(wordDictionary.search("qsibz.aorkty.kfg"));
//        wordDictionary.addWord("sm");
//        wordDictionary.addWord("fkqclfmvzpzpnbvz");
//        System.out.println(wordDictionary.search("vb..uvrkbcq"));
//        wordDictionary.addWord("jpnneostllnnma");
//        wordDictionary.addWord("zvmtfg");
        System.out.println(wordDictionary.search(".g.."));
    }
}

class WordDictionary {

    private final TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode target = current.children[word.charAt(i) - 'a'];
            if (target == null) {
                target = new TrieNode();
                current.children[word.charAt(i) - 'a'] = target;
            }
            current = target;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return recursive(word, 0, root);
    }

    private boolean recursive(String word, int i, TrieNode root) {
        if (i == word.length()) {
            return root.isEnd;
        }
        if (word.charAt(i) == '.') {
            for (TrieNode child : root.children) {
                if (child != null) {
                    if (recursive(word, i + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (root.children[word.charAt(i) - 'a'] == null) {
            return false;
        }
        return recursive(word, i + 1, root.children[word.charAt(i) - 'a']);
    }
}

class TrieNode {

    final TrieNode[] children = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;
    }
}
