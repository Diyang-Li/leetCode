package monotoneQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Diyang Li
 * @create 2022-09-01 5:05 PM
 */
public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public int longestSubarray(int[] nums, int limit) {
        //本质上还是sliding window
        // increasing deque for recording smallest num in window
        // decreasing deque for recording largest num in the window
        Deque<Integer> in = new ArrayDeque<>();
        Deque<Integer> de = new ArrayDeque<>();
        int res = 0;

        int left = 0;
        int right = 0;
        while(right < nums.length){
            // increase:peekFirst should be the smallest num in the window
            while(!in.isEmpty() && nums[right] < in.peekLast()){
                in.pollLast();
            }
            // decrease: peekFirst should be the largest num in the window
            while(!de.isEmpty() && nums[right] > de.peekLast()){
                de.pollLast();
            }

            in.offer(nums[right]);
            de.offer(nums[right]);

            //shink the window
            while(!in.isEmpty() && !de.isEmpty() && de.peekFirst() - in.peekFirst() > limit){
                if(de.peekFirst() == nums[left]) de.pollFirst();
                if(in.peekFirst() == nums[left]) in.pollFirst();
                left++;
            }

            res = Math.max(res, right - left +1);

            right++;
        }

        return res;
    }
}
