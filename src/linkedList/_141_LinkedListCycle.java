package linkedList;

/**
 * @author Diyang Li
 * @create 2022-07-01 6:46 PM
 */
public class _141_LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * fast and slow pointer
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head;

        while(fast != slow){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }


}
