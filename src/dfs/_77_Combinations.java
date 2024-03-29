package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-24 10:47 AM
 */
public class _77_Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n , k, 1);
        return res;
    }

    private void backtracking(int n, int k, int start){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++){
            temp.add(i);
            backtracking(n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }

}
