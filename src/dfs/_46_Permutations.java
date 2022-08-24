package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-24 4:39 PM
 */
public class _46_Permutations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtracking(nums);
            temp.remove(temp.size()-1);
        }
    }

    /**
     * [1,2,3]
     * take 1 for instance: i = 0--> [1]
     *                               i = 0 -->[1,1](X)
     *                               i = 1 -->[1,2]
     *                                         i = 0 --> [1,2,1](X)
     *                                         i = 1 --> [1,2,2](X)
     *                                         i = 2 --> [1,2,3](Y)
     *                               i = 2 -->[1,3]
     *                                         i = 0 --> [1,3,1](X)
     *                                         i = 1 --> [1,3,2](Y)
     *                                         i = 2 --> [1,3,3](X)
     */
}
