package scanLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-13 7:08 PM
 */
public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][0];

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a1, a2)->{
            return a1[0] - a2[0];
        });

        int[] last = intervals[0];

        for(int[] cur: intervals){
            if(cur[0] <= last[1]){
                last[1] = Math.max(last[1], cur[1]);
            } else{
                res.add(last);
                last = cur;
            }

        }

        res.add(last);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][0];

        System.out.println(Arrays.toString(arr[1]));
    }


}
