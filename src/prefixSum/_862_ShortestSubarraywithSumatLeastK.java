package prefixSum;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Diyang Li
 * @create 2022-09-07 11:23 AM
 */
public class _862_ShortestSubarraywithSumatLeastK {
    /**
     * if all numbers are positive, we could use sliding window, like 209
     * Because k >= 1, so we wanna use a larger sum - smaller sum >= k
     * // try[]56, -21, 56 , 35, -9] --> [0, 56, 35, 91, 126, 117]
     *                                        l           r
     *                                        sum[r] -sum[l] < 61 so right have to move right
     *                                        miss the 126 - 35 >= 61
     *                                        if use deque, 56 is removed from deque, then can archive 126 - 35 >= 61 --> res = 2
     * @param nums
     * @param k
     * @return
     */
    public static int shortestSubarray1(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        int len = sum.length;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && sum[i] <= sum[dq.peekLast()]) {
                dq.pollLast();
            }

            while (!dq.isEmpty() && sum[i] - sum[dq.peekFirst()] >= k) {
                res = Math.min(res, i - dq.pollFirst());
            }

            dq.offerLast(i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}


