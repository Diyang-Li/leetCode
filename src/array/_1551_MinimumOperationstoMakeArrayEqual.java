package array;

/**
 * @author Diyang Li
 * @create 2022-06-27 2:52 PM
 */
public class _1551_MinimumOperationstoMakeArrayEqual {
    public static int minOperations(int n) {
        // 1. arr[i] = (2 * i) + 1
        int opera = 0;
        if(n == 1) {
            return opera;
        }

        for(int i = 0; i < n/2; i++){
            opera += n - ((2*i)+1);
        }

        return opera;
    }

    public static void main(String[] args) {
        int num1 = 6;
        System.out.println(minOperations(num1));
    }
}
