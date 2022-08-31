package monotonicStack;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-30 11:12 AM
 */
public class _42_TrappingRainWater {

    public int trap(int[] height) {
        // record the position in the height, because the index can be used to calculate the length of each pool
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            // has pool to store water
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()) break; // there is no left wall
                int h = Math.min(height[i], height[stack.peek()]); // select lower wall in left and right walls
                res += (h - height[bottom]) * (i - stack.peek()-1);
            }

            stack.push(i);
        }

        return res;
    }
}
