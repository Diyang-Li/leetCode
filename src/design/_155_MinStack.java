package design;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-09-14 4:34 PM
 */
public class _155_MinStack {
    Stack<int[]> stack;
    public _155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
        }else{
            int minVal = Math.min(stack.peek()[1], val);
            stack.push(new int[]{val, minVal});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        System.out.println("he");
    }

}
