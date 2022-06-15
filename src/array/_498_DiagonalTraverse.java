package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Diyang Li
 * @create 2022-06-15 12:13 PM
 */
public class _498_DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0){
            return new int[]{};
        }
        //[sum of layer, column, value]
        int[][] record = new int[mat.length * mat[0].length][3];
        int[] result = new int[record.length];
        int index = 0;
        for(int i = 0; i<mat.length; i++){
            for (int j = 0; j<mat[0].length; j++){
                record[index] = new int[]{i+1, j, mat[i][j]};
                index ++;
            }
        }

        Arrays.sort(record, new Comparator<int[]>(){
            public int compare(int[]a, int[]b){
                if(a[0] !=  b[0]){
                    return a[0]-b[0];
                }
                //even layer
                if(a[0] % 2 == 0){
                    return a[1] - b[1];
                }
                return -(a[1] - b[1]);
            }
        });

        for(int i = 0; i < record.length; i++){
            result[i] = record[i][2];
        }

        return result;
    }
}
