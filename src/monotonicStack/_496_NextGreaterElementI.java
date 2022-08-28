package monotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-27 4:41 PM
 */
public class _496_NextGreaterElementI {
    /**
     * O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()) stack.pop();
            map.put(nums2[i],stack.isEmpty()? -1: stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) res[i] = map.get(nums1[i]);
        return res;
    }
}
