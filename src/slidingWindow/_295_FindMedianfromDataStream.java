package slidingWindow;

import java.util.PriorityQueue;

/**
 * @author Diyang Li
 * @create 2022-07-20 1:10 PM
 */
public class _295_FindMedianfromDataStream {
    /**
     * use priority queue to find the medium
     */
    private PriorityQueue<Long> large;
    private PriorityQueue<Long> small;

    public _295_FindMedianfromDataStream() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if(large.size() < small.size()){
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size()? large.peek(): (large.peek() - small.peek())/2.0;
    }
}
