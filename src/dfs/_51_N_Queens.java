package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-10-02 12:11 PM
 */
public class _51_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        // build chessborad
        char[][] board = new char[n][n];
        for(char[] arr: board){
            Arrays.fill(arr, '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtracking(board, n, 0, res); // board = path
        return res;
    }

    private void backtracking(char[][] board, int n, int row, List<List<String>> res){
        // row if fixed, because each row only has one Q,try each col in the same row
        if(row == n){
            res.add(construct(board));
        }
        for(int col = 0; col < n; col++){
            if(valid(board, row, col)){
                board[row][col] = 'Q';
                backtracking(board, n, row+1, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col){
        // only need to check [0 ~ row-1], because the rest row has not been tried
        for(int x = 0; x < row; x++){
            for(int y = 0; y < board.length; y++){
                if(board[x][y] == 'Q' &&(y == col || x + col == y+row || x+y ==col + row)){
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(char[] arr: board){
            res.add(new String(arr));
        }
        return res;
    }
}
