package array;

/**
 * @author Diyang Li
 * @create 2022-06-20 9:53 AM
 */
public class _59_SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int rowStart =0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int[][] result = new int[n][n];

        int index = 1;

        while(index <= n*n){
            //top line
            for(int r = rowStart, c = colStart; c<=colEnd; c++){
                result[r][c] = index++;
            }
            rowStart++;

            //right line
            if(index <= n*n){
                for(int r = rowStart, c = colEnd; r <= rowEnd; r++){
                    result[r][c] = index++;
                }
                colEnd--;}

            if(index <= n*n){
                //buttom line
                for(int r = rowEnd, c = colEnd; c >= colStart; c--){
                    result[r][c] = index++;
                }
                rowEnd--;}


            if(index <= n*n){
                //left line
                for(int r = rowEnd, c=colStart; r>=rowStart; r--){
                    result[r][c] = index++;
                }
                colStart++;}
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;
        int[][] ints = generateMatrix(n2);
        System.out.println(ints);
    }
}
