package scanLine;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-08-14 12:29 PM
 */
public class _435_Non_overlappingIntervals {
    /**
     * method 1:
     * method use greedy
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals,(a1, a2)->{
            return a1[1] - a2[1];
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int[] cur: intervals){
            if(cur[0] >= end){
                end = cur[1];
            }else{
                count++;
            }
        }

        return count;
    }
}
