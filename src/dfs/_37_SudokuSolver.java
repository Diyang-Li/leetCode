package dfs;

/**
 * @author Diyang Li
 * @create 2022-08-25 3:33 PM
 */
public class _37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char c) {
        //Each of the digits 1-9 must occur exactly once in each column.
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) return false;
        }
        //Each of the digits 1-9 must occur exactly once in each row.
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) return false;
        }
        // Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (board[row][col] == c) return false;
            }
        }
        return true;
    }
}
