package array;

/**
 * @author Diyang Li
 * @create 2022-06-15 10:24 AM
 */
public class _766_ToeplitzMatrix {
    /**
     * O(n3)
     * @param matrix
     * @return
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                int k = i + 1;
                int m = j + 1;
                while (k < row && m < col) {
                    if (matrix[k][m] != cur) {
                        return false;
                    }
                    k++;
                    m++;
                }
            }
        }

        return true;
    }

    /**
     * optimized O(mn)
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i =1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] matrix0 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix1 = {{1, 2}, {2, 2}};
        int[][] matrix2 = {{65, 98, 57}};
        int[][] matrix3 = {{11, 74, 0, 93}, {40, 11, 74, 7}};

        System.out.println(isToeplitzMatrix(matrix1));

    }
}
