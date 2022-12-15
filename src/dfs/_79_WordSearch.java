package dfs;

/**
 * @author Diyang Li
 * @create 2022-12-15 11:17 AM
 */
public class _79_WordSearch {
    // O(n*3^L) n is the size of the grid, 3 means 3 direction and L is the word length
    // O(L) the all stack is the length of the word
    //1. we have to find the word firstly
    //2. compared the each char
    int[] mx = {0,0,1,-1};
    int[] my = {1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        // find the char in board that matches the first char in the word
        for(int x = 0; x < row; x++){ // O(n*3^L) n is the size of the grid, 3 means 3 direction and L is the word length
            for(int y = 0; y < col; y++){
                if(backtracking(board, word, 0, x, y)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int pos, int x, int y){
        // have already check all the char and passed, just return true;
        if(pos >= word.length()){
            return true;
        }
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(pos)){
            return false;
        }
        boolean exist = false;

        if(board[x][y] == word.charAt(pos)){
            // change the char at current xy, to avoid use the same char repleatly
            char cur = board[x][y];
            board[x][y] = '*';// we cannot go back

            for(int i = 0; i < 4; i++){
                exist = backtracking(board, word, pos+1, x+mx[i], y+my[i]);
                if(exist){
                    break;
                }
            }

            // change the char at current * back;
            board[x][y] = cur;
        }

        return exist;
    }
}
