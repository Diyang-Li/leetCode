package linkedList;

/**
 * @author Diyang Li
 * @create 2022-06-29 11:36 AM
 */
public class _61_RotateList {
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

    /**
     * my method, traverse then head and get the number of nodes, then get the last k nodes is cur
     * the last node of cur point to the head.
     * O(n) O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        k = k % count;
        if (k == 0) {
            return head;
        }

        int step = count - k;
        cur = head;

        ListNode tail = null;

        // reverse the last k node;
        while (step > 1) {
            cur = cur.next;
            step--;
        }

        tail = cur;
        cur = cur.next;    //  cur --> 4 ->5-> null;
        tail.next = null;


        // last node of cur next is head;
        ListNode temp = cur;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return cur;
    }
}
