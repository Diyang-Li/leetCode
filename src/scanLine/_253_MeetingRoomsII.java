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
        Arrays.sort(intervals, (a, b)-> {
            return a[0] - b[0];
        });

        //use peek() to find out the ealist end meeting, then pop out, which means the meeting has ended
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[1] - b[1];
        });
        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(pq.peek()[1] <= intervals[i][0]){
                pq.poll();// the peek meeting has already ended
            }
            pq.offer(intervals[i]);
        }

        return pq.size();
    }

}
