package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-24 3:25 PM
 */
public class _90_SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>(temp));
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start){
        if(start >= nums.length) return;

        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backtracking(nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
