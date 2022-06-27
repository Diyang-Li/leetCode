package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-27 11:17 AM
 */
public class _1304_FindNUniqueIntegersSumutoZero {
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int index = 0;

        for(int i = 1; i <= n/2; i++){
            res[index++] = i;
            res[index++] = -i;
        }

        return res;
    }

    public static void main(String[] args) {
        int i = 5;
        System.out.println(Arrays.toString(sumZero(i)));
    }
}
