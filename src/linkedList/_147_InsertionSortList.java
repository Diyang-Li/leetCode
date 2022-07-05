package linkedList;

import java.util.zip.CRC32;

/**
 * @author Diyang Li
 * @create 2022-07-05 9:52 AM
 */
public class _147_InsertionSortList {
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
     * brute force O(n^2) O(1)
     * Runtime: 144 ms, faster than 5.20% of Java online submissions for Insertion Sort List.
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head; // record current node
        ListNode temp = null; // record cur.next to compare and swap
        ListNode tail = null;// record the node that has sorted: 4 2 1 3 -> 2 1 3 4, the tail on 4, because the node after 4 has already sorted

        while(tail != dummy.next){
            pre = dummy;
            cur = dummy.next;
            temp = cur.next;

            while(cur.next != null && temp != tail){
                if(cur.next.val < cur.val){
                    cur.next = temp.next;
                    temp.next = cur;
                    pre.next = temp;
                    pre = temp;
                    temp = cur.next;
                }else{
                    pre = cur;
                    cur = cur.next;
                    temp = cur.next;
                }

            }

            tail = cur;
        }

        return dummy.next;
    }

    /**
     * A better method, O(n) O(1)
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head; // record the current node
        ListNode pre = null;
        ListNode temp = null;

        while (cur != null && cur.next != null){
            if (cur.val <=cur.next.val) {
                cur = cur.next; // cur always point to a larger one
            }else{
                temp = cur.next;
                pre = dummy; // pre comback to the dummy each time,
                // we assume that the nodes before the cur has already sorted, pre help to find the position of
                // temp in the sorted nodes. so, when cur come to the last node
                cur.next = temp.next;
                while (pre.next.val < temp.val){
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;

            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(5);

        insertionSortList(node);
    }
}
