package slidingWindow;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Diyang Li
 * @create 2022-07-21 11:32 AM
 */
public class _239_SlidingWindowMaximum {
    /**
     * Time Limit Exceeded with insert sort
     * The best methos is using deque
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int right = 0;
        Deque<Integer> queue = new LinkedList<>();
        int[] rest = new int[nums.length - k + 1];

        while(right < nums.length){
            // to control the size of the deque, the queue is the window
            if(!queue.isEmpty() && right-k == queue.peekFirst()){
                queue.poll();
            }

            // always make the first is the largest one
            while(!queue.isEmpty() && nums[right] > nums[queue.peekLast()]){
                queue.removeLast();
            }

            queue.offerLast(right);

            if(right + 1 >= k){
                rest[right - k + 1] = nums[queue.peekFirst()];
            }
            right++;
        }

        return rest;
    }


}
