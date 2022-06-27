package binarySearch;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-06-13 10:18 PM
 */
public class _436_FindRightInterval {
    /**
     * The key point of this problem
     * 1. if I have a interval and want to find the right interval,
     *     the last num of this interval <= first num of right interval, use the left of binary search
     * 2. use a hashmap to record the position of each interval
     * 3. extract the start num of each interval
     * 4. sort the array
     * 5. loop the interval, get the last num of each interval, then use BS to find the <= most near left number
     * @param intervals
     * @return
     */
    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        // [[3,4],[2,3],[1,2]]
        HashMap<Integer, Integer> startMap = new HashMap<>();
        //{3: 0, 2:1, 1:2}
        int[] starts = new int[len];
        for(int i = 0; i<len; i++){
            startMap.put(intervals[i][0], i);
            starts[i] = intervals[i][0];
        }

        // start = [3,2,1] -- [1,2,3]
        Arrays.sort(starts);
        int[] res = new int[len];
        // len = 3
        for(int i = 0; i<len; i++){
            // starts = [3,2,1] -- [1,2,3]
            // i = 1,                           3
            int idx = findInterval(starts, intervals[i][1]);
            res[i] = idx==-1? -1: startMap.get(starts[idx]);
        }
        return res;
    }

    //left binary search            [1,2,3]          3   最小的大于等3的一个数
    public static int findInterval(int[] starts, int target){
        if(target > starts[starts.length-1]){
            return -1;
        }

        int left = 0;
        int right = starts.length-1;

        while (left < right){
            int mid = left + (right - left)/2;
            if(starts[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    // [3, 4] [5, 6] [7,8]
    //        [2,3]
    public static void main(String[] args) {
        int[][] nums = {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(nums)));
    }
}
