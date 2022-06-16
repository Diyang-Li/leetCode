package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-16 10:23 AM
 */
public class _54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        List<Integer> result = new ArrayList<Integer>();

        // Actually this should satisfied at the same time, but we need to consider 4 lines at the same time
        // so in order to avoid one of them is not satisfied, we need to add if condition in the loop process
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //line one
            for (int i = rowBegin, j = colBegin; j <= colEnd; j++) {
                result.add(matrix[i][j]);
            }
            rowBegin++;

            //line two
            for (int i = rowBegin, j = colEnd; i <= rowEnd; i++) {
                result.add(matrix[i][j]);
            }
            colEnd--;

            // the line one and two cannot conflict rowBegin <= rowEnd && colBegin <= colEnd
            // because the while just help to judge it
            // but in the following process, BC of row and col is still changing, so we need to judge with two if

            //line three
            //When row begin > roEnd is meaningless
            if (rowBegin <= rowEnd) {
                for (int i = rowEnd, j = colEnd; j >= colBegin; j--) {
                    result.add(matrix[i][j]);
                }
                rowEnd--;
            }

            //line four
            //When col begin > col End is meaningless
            if (colBegin <= colEnd) {
                for (int i = rowEnd, j = colBegin; i >= rowBegin; i--) {
                    result.add(matrix[i][j]);
                }
                colBegin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(matrix1);
    }
}
