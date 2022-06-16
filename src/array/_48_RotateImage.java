package array;

/**
 * @author Diyang Li
 * @create 2022-06-15 9:43 PM
 */
public class _48_RotateImage{
    public static void rotate(int[][] matrix) {
        // switch the numbers on both side of  diagonal
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // switch the numbers on both side of vertical diagonal
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
