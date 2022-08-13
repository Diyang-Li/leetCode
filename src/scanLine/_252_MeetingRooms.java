package scanLine;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-08-12 4:12 PM
 */
public class _252_MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a1, int[] a2) ->{
            return a1[0] - a2[0];
        });
        //[[7,10],[2,4]] -> [[2,4], [7,10]]
        for(int i = 0; i<intervals.length -1; i++){
            if(intervals[i][1] - intervals[i+1][0] > 0) return false;
        }

        return true;
    }

}
