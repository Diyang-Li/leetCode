package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2022-10-06 3:35 PM
 */
public class _70_ClimbingStairs {
    /**
     * dfs
     * state function: d[i] = d[i-1] + d[i-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] step = new int[n+1];
        return helper(n, step);
    }

    private int helper(int n, int[] step){
        if(n <= 2) return n;
        if(step[n] != 0){
            return step[n];
        }
        step[n] = helper(n-1, step)+helper(n-2, step);
        return step[n];
    }

    /**
     * iteration
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n <= 2){
            return n;
        }
        int[] steps = new int[n+1];
        steps[1]=1;
        steps[2] = 2;
        for(int i = 3; i <= n; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }

        return steps[n];
    }
}
