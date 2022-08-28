package monotonicStack;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-27 11:40 PM
 */
public class _739_DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length-1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= stack.peek()) stack.pop();
            res[i] = stack.isEmpty()? 0: stack.peek() - i;
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] tem = {73,74,75,71,69,72,76,73};
        dailyTemperatures(tem);
    }
}
