package linkedList;

/**
 * @author Diyang Li
 * @create 2022-06-30 4:40 PM
 */
public class _445_AddTwoNumbersII {
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
     * same method as the 2 Add Ewo Numbers, just we need to reverse the head before and after the sum operation
     * O(n) O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode rest = new ListNode(0);


        int sum = 0;

        ListNode p1 = l1, p2 = l2;
        ListNode cur = rest;

        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if(sum == 1){
            cur.next = new ListNode(1);
        }
        rest = reverse(rest.next);

        return rest;
    }

    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
