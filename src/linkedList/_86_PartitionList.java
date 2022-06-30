package linkedList;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-30 3:28 PM
 */
public class _86_PartitionList {
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
     * use dummy O(n), O(n), O(1)
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        // at least two nodes not null;
        // if we don't use dummy, when the first element >= x, p2 point to the next node of the first node,
        // we cannot compare the p2 with x;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy; //slow
        ListNode p2 = p1.next; // fast
        ListNode p3 = dummy; // node before the fast

        while (p2 != null){
            //p2 come to the node < x
            if(p2.val < x){
                p3.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p1.next;
            }
            p3 = p2;
            p2 = p2.next;
        }

        return dummy.next;
    }

    /**
     * Another way: seperate the values and combain together: O(n) O(n)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode smallHead = new ListNode(0),
                bigHead = new ListNode(0),
                small = smallHead,
                big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
   /*     node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);*/

        partition(node, 2);
    }
}
