package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-24 12:03 PM
 */
public class _78_Subsets {
    /**
     * backtracking
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(temp));
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start){
        if(start >= nums.length) return;

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backtracking(nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    /**
     * mask: binary
     * link: https://www.youtube.com/watch?v=51swSnpkoSI&list=PLbaIOC0vpjNW6V4ZTd5OpURZ6m0mf0G8n&index=3
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        int totalNum = 1<< nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int mask = 0; mask < totalNum; mask++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if((mask & (1 << j)) != 0) temp.add(nums[j]);
            }

            res.add(temp);
        }

        return res;
    }
}
