package dfs;

/**
 * @author Diyang Li
 * @create 2022-08-25 3:33 PM
 */
public class _37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    // this backtracking has return
    private boolean solve(char[][] board){
        // for each part
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // treatment
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(c, i, j, board)){
                            board[i][j] = c;
                            // backtracking
                            if(solve(board)){
                                return true;
                            }else{
                                // if not, then revoke
                                board[i][j]= '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int c, int i, int j, char[][] board){
        // row
        for(int row = 0; row < 9; row ++){
            if(board[row][j] == c){
                return false;
            }
        }

        // cloumn
        for(int col = 0; col < 9; col++){
            if(board[i][col] == c){
                return false;
            }
        }
        // 9X9
        int rowStart = (i/3)*3;
        int rowEnd = rowStart + 3;
        int colStart = (j/3)*3;
        int colEnd = colStart+3;
        for(int row = rowStart; row < rowEnd; row++){
            for(int col = colStart; col < colEnd; col++){
                if(board[row][col] == c){
                    return false;
                }
            }
        }
        return true;
    }
}
