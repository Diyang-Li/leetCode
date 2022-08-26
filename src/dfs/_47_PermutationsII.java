package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-25 11:13 AM
 */
public class _47_PermutationsII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used);
        return res;
    }


    public void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // if i has used in current path, cannot be used again
            // if(i > 0) and the i-1 has not been used, means the same i-1 nums used in pre path
            // so when a number has the same value with its previous, we can use this number only if the previous is used
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))continue;
            used[i]= true;
            path.add(nums[i]);
            backtracking(nums, used);
            path.remove(path.size()-1);
            used[i] = false;
        }

    }
}
