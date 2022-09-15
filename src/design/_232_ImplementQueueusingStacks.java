package design;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-09-14 9:07 PM
 */
public class _232_ImplementQueueusingStacks {
    Stack<Integer> stack;
    Stack<Integer> queue;

    /**
     * Fellow up O(1) solution
     */
    public _232_ImplementQueueusingStacks() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        peek();
        return queue.pop();
    }

    public int peek() {
        if(queue.isEmpty()){
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
    }
}
