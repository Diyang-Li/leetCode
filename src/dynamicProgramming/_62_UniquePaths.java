package dynamicProgramming;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-09-19 10:17 AM
 */
public class _62_UniquePaths {
    // function: f(i, j) = f(i-1, j) + f(i, j-1);
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        //从上到下，从左到右，f(i, j)前面的都是已经算好的
        for(int i = 0; i <m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j== 0){
                    f[i][j] = 1;
                }else{
                    f[i][j] = f[i-1][j]+f[i][j-1];
                }
            }
        }
        for(int i = 0; i < m; i++){
            System.out.println(Arrays.toString(f[i]));
        }
        return f[m-1][n-1];
    }
}
