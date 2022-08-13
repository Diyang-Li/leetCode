package scanLine;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-08-12 5:04 PM
 */
public class _253_MeetingRoomsII {
    /**
     * template 1
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for(int[] i: intervals){
            list.add(new int[]{i[0], 1});
            list.add(new int[]{i[1], -1});
        }

        Collections.sort(list, (a1, a2)->{
            if(a1[0] == a2[0]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        int num = 0;
        int cur = 0;
        for(int[] i: list){
            cur += i[1];
            num = Math.max(num, cur);
        }
        return num;

    }

    /**
     * offical template priority queue
     * @param intervals
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) ->{
            return a1[1] - a2[1];
        });

        q.offer(intervals[0]);

        for(int i = 1; i<intervals.length; i++){
            int[] last = q.poll();
            int[] cur = intervals[i];

            if(last[1] <= cur[0]) {
                last[1] = cur[1];
            }else{
                q.offer(cur);
            }

            q.offer(last);
        }

        return q.size();
    }

}
