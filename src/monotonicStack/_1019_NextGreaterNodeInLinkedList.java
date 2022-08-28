package monotonicStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-27 10:16 PM
 */
public class _1019_NextGreaterNodeInLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode i = head; i != null; i = i.next) list.add(i.val);
        int len = list.size();
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }

        return res;
    }
}
