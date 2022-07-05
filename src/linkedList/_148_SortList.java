package linkedList;

/**
 * @author Diyang Li
 * @create 2022-07-05 11:58 AM
 */
public class _148_SortList {
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
     * Divide and Conquer : O(nlogn) O(1)
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMid(head);
        ListNode l2 = middle.next;
        ListNode l1 = head;
        middle.next = null;

        ListNode left = sortList(l1);
        ListNode right = sortList(l2);

        return merge(left, right);
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
