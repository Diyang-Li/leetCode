package dfs;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-10-03 11:52 AM
 */
public class _1723_FindMinimumTimetoFinishAllJobs {
    /**
     * Using bfs, but the time limit exceeded
     */
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        dfs(jobs, new int[k], jobs.length-1);
        return res;
    }

    private void dfs(int[] jobs, int[] sum, int pos){
        if(pos < 0){
            res = Math.min(res, Arrays.stream(sum).max().getAsInt());
            return;
        }
        //put jobs[pos] in sum[i],
        //
        for(int i = 0; i < sum.length; i++){
            if(i > 0 && sum[i] == sum[i-1]){
                continue;
            }
            sum[i]+=jobs[pos];
            dfs(jobs, sum, pos-1);
            sum[i]-=jobs[pos];
        }
    }

    public static void main(String[] args) {
        String s = "     s   t s";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
    }
}
