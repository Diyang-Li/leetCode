package scanLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-14 12:28 PM
 */
public class _1272_RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        for(int[] cur: intervals){
            if(toBeRemoved == null || cur[1] <= toBeRemoved[0] || cur[0]>= toBeRemoved[1]) {
                res.add(Arrays.asList(cur[0], cur[1]));
            }else{
                // cur[1]>= toBeRemoved[0] && cur[0] <=toBeRemoved[1]
                if(cur[0] < toBeRemoved[0]){
                    res.add(Arrays.asList(cur[0], toBeRemoved[0]));
                }
                if(cur[1] > toBeRemoved[1]){
                    res.add(Arrays.asList(toBeRemoved[1], cur[1]));
                    toBeRemoved = null;
                }
            }
        }

        return res;
    }
}
