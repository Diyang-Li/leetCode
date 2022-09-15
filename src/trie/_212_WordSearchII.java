package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Diyang Li
 * @create 2022-09-14 12:11 PM
 */
public class _212_WordSearchII {
    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        // record if the cell has been visited
        boolean[][] visited = new boolean[row][col];
        //put words in a Trie
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        //use dfs to put words in the res;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(board, trie,visited,"", i, j);
            }
        }

        return new ArrayList<String>(res);
    }
    //board:given board
    //trie: trie include words
    //str: current String, string cannot be changed
    //i: row index
    //j:col pos index
    private void dfs(char[][] board, Trie trie, boolean[][] visited, String str, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(visited[i][j]) return;
        str += board[i][j];
        //if the prefix(str) not in the trie, means there is no such words in the trie, dfs剪枝
        if(!trie.startWith(str)){
            return;
        }
        //if find the word, add to the res
        if(trie.search(str)){
            res.add(str);
        }
        // the char has already visited
        visited[i][j] = true;
        //dfs in 4 directions
        dfs(board, trie, visited, str, i+1, j);
        dfs(board, trie, visited, str, i-1, j);
        dfs(board, trie, visited, str, i, j+1);
        dfs(board, trie, visited, str, i, j-1);
        visited[i][j] = false;
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }

            node.isWord = true;
        }

        public boolean search(String word){
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

        public boolean startWith(String prefix){
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
}
