package monotoneQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Diyang Li
 * @create 2022-08-31 4:47 PM
 */
public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque();
        int len = nums.length;
        int[] res = new int[len - k + 1];

        for(int i = 0; i < len; i++){
            int startWith = i - k + 1;
            // if the q size <= then k
            while(!d.isEmpty() && i - d.peekFirst() >= k) d.pollFirst();
            while(!d.isEmpty() && nums[i] > nums[d.peekLast()]) d.pollLast();
            d.offerLast(i);
            if(startWith >= 0) res[startWith] = nums[d.peekFirst()];
        }

        return res;
    }
}
