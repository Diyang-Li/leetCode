package scanLine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-13 11:14 PM
 */
public class _57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int[] cur: intervals){
            // newInterval larger then the largets element in the intervals, just add all the cur in the res;
            if(newInterval == null || cur[1] < newInterval[0]){
                res.add(cur);
                // newInterval smaller then the smallest one in the array[i~last one]
            }else if(cur[0] > newInterval[1]){
                res.addAll(List.of(newInterval, cur));
                newInterval = null; // the newInterval has added into the res, no newInterval;
            }else{
                // new[1] >= cur[0] || new[0] <= cur[1]
                // at least part of new in the cur;
                // merge the newInterval with cur
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        if(newInterval!=null){
            res.add(newInterval);  //[[1,5]] add[2,3];
        }

        return res.toArray(new int[0][]);
    }
}
