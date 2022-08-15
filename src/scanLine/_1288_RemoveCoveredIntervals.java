package scanLine;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-08-14 3:38 PM
 */
public class _1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a1, a2) -> {
            if(a1[0] == a2[0]) return a2[1] - a1[1];
            return a1[0] - a2[0];
        });


        //[[1,2],[1,4],[3,4]]
        // [1,4] [1,2] [3,4]
        // if the range of last interval is larger then the cur one, the cur will be covered
        // the last[0] <= cur[0], so we just need to compare the last[1] and cur[1]
        int count = 0;
        int preEnd = 0;

        for(int[] cur: intervals){
            if(preEnd < cur[1]){
                count++;
                preEnd = cur[1];
            }
        }

        return count;
    }
}
