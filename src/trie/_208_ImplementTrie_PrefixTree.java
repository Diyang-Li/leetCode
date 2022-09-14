package trie;

/**
 * @author Diyang Li
 * @create 2022-09-13 10:14 PM
 */
public class _208_ImplementTrie_PrefixTree {
    TrieNode root;
    public _208_ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c -'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }

        return true;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
    }
}
