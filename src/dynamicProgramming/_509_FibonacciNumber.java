package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2022-10-06 4:34 PM
 */
public class _509_FibonacciNumber {
    // function: dp[i] = dp[i-1] + dp[i-2];
    public int fib(int n) {
        int[] res = new int[n+1];
        return dp(n, res);
    }

    private int dp(int n,int[] res){
        if(n <= 1){
            return n;
        }
        if(res[n] != 0){
            return res[n];
        }

        res[n] = dp(n-1, res)+dp(n-2, res);
        return res[n];
    }

    public static void main(String[] args) {
        String s= "123";
        int one = Integer.parseInt(s.substring(1,2));

    }
}
