package trie;

/**
 * @author Diyang Li
 * @create 2022-09-14 10:07 AM
 */
public class _211_DesignAddandSearchWordsDataStructure {
    TrieNode root;
    public _211_DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int pos, TrieNode node){
        // reach the end of current path
        if(word.length() == pos) {
            return node.isWord;
        }
        // pos is the index of the char in word, notice the first root is children that all indexes are empty
        char c = word.charAt(pos);
        if(c != '.'){
            return node.children[c - 'a'] != null && helper(word, pos+1, node.children[c - 'a']);
        }else{
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null && helper(word, pos + 1, node.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
}

