package linkedList;

import java.nio.file.Watchable;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-28 10:07 AM
 */
public class _24_SwapNodesinPairs {
    public static class ListNode {
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

    /**
     * iteration: 4 pointers
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        ListNode next = null;
        ListNode temp = null;

        while (cur.next != null && cur.next.next != null){
            next = head.next;
            temp = next.next;
            cur.next = next;
            next.next = head;
            head.next = temp;
            cur = head;
            head = head.next;
        }
        return res.next;
    }

    /**
     * recursion
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs1(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);

        ListNode listNode = swapPairs1(node);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
