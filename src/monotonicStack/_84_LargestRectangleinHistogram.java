package monotonicStack;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-31 10:02 AM
 */
public class _84_LargestRectangleinHistogram {
    /**
     * monotonic stack: O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if(heights == null || len == 0) return 0;
        // items in stack is the index of the heights
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int pre = stack.pop();
                // here must be stack.peek()+1, [3,6,5,7,4,8,1,0]
                // the all number in the stack are increase, include the number that skipped
                // so the pre <= all numbers in [stack.peek() + 1, i）[4 2 0 3 2 5] for example
                int width = i - (stack.isEmpty()? 0: stack.peek() +1);
                res = Math.max(res, width * heights[pre]);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int pre = stack.pop();
            int width = len - (stack.isEmpty()? 0: stack.peek() +1);
            res = Math.max(res, width*heights[pre]);
        }

        return res;
    }
    /**
     * method 1: divide and conquer, O(nlogn), but time limit exceeded
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        return divide(heights, 0, heights.length-1);
    }

    private static int divide(int[] heights, int left, int right){
        if(left > right) return 0;

        int minHeight = left;
        for(int i = left ; i <= right; i++){
            if(heights[minHeight] > heights[i]) minHeight = i;
        }

        int cur = heights[minHeight] * (right - left + 1);
        int leftRec = divide(heights, left, minHeight-1);
        int rightRec = divide(heights, minHeight+1, right);

        return Math.max(cur, Math.max(leftRec, rightRec));
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,6,2,3};
        largestRectangleArea(array);
    }
}
