package monotonicStack;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-27 8:51 PM
 */
public class _503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = len*2-1; i >= 0; i--){
            // 第一遍是为了在找到当前num的next element的同事，把一个从左到右的递增顺序整理出来
            //第二遍，事实上就是直接从stack中pop
            while(!stack.isEmpty() && nums[i % len] >= stack.peek()) stack.pop();
            res[i % len] = stack.isEmpty()? -1: stack.peek();
            stack.push(nums[i%len]);
        }

        return res;
    }
}
