package prefixSum;

/**
 * @author Diyang Li
 * @create 2022-09-07 10:43 AM
 */
public class _304_RangeSumQuery2D_Immutable {
    int[][] sums;

    public _304_RangeSumQuery2D_Immutable(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sums = new int[row+1][col+1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
    }
}
