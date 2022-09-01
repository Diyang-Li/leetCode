package monotoneQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Diyang Li
 * @create 2022-09-01 10:36 AM
 */
public class _862_ShortestSubarraywithSumatLeastK {
    //prefix sum
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        int res = len+1;
        long[] psum = new long[len+1];
        for(int i = 0; i < len; i++){
            // 后错一位记录前i个数的sum
            psum[i+1] = nums[i] + psum[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        // loop the psum
        for(int i = 0; i <= len; i++){
            while(!dq.isEmpty() && psum[i] - psum[dq.peekFirst()] >= k){
                res = Math.min(res, i-dq.pollFirst());
            }

            while(!dq.isEmpty() && psum[i] <= psum[dq.peekLast()]){
                //keep the increasing order in the deque
                dq.pollLast();
            }

            dq.offerLast(i);
        }
        return res <= len? res: -1;
    }
}
