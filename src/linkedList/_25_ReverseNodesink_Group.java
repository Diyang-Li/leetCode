package linkedList;

/**
 * @author Diyang Li
 * @create 2022-06-29 10:31 AM
 */
public class _25_ReverseNodesink_Group {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int count = 0; // count nodes
        ListNode cur = head;

        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }

        if(count == k){
            cur = reverseKGroup(cur, k); //put the next gourp of nodes into the recursion
            // reverse the current group of nodes
            while (count > 0){ // reverse n nodes means n times reverse operation
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
                count--;
            }

            head = cur;
        }

        return head;
    }

}
