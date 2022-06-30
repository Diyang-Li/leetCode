package linkedList;

/**
 * @author Diyang Li
 * @create 2022-06-30 3:22 PM
 */
public class _2_AddTwoNumbers {
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
     * this is a special method need to remember
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;

        // actually, we could || to move ond of pointers, this is the best way!
        // With the following method, we could ignore the val of node that is null
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10; //recording the decimal
            cur = cur.next;
        }

        if (sum > 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
