package linkedList;

/**
 * @author Diyang Li
 * @create 2022-07-03 3:52 PM
 */
public class _143_ReorderList {
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
     * use a rest listNode to link the node, O(n) O(n)
     * @param head
     */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode rest = new ListNode(0);
        ListNode cur = rest;

        // find middle 1 2 3 4 middle -> 2
        ListNode middle = findMiddle(head);

        // reverse the next list of middle: 1 2 4 3
        middle.next = reverse(middle.next);

        ListNode p1 = head; // p1->1
        ListNode p2 = middle.next; // p2 -> 4

        while (p2 != null){
            cur.next = p1; // res(0) 1
            p1 = p1.next;
            cur = cur.next;
            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;

        }
        // if the length is odd, add the middle to the last one of the rest;
        if(p1 == middle){
            cur.next = new ListNode(middle.val);
        }

        head = rest.next;
    }

    /**
     * seperate the linkedlist, and merge them O(n) O(1)
     * @param head
     */
    public static void reorderList1(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // seperate the ListNode to l1 and l2, reverse the l2
        ListNode l1 = head;
        temp.next = null;
        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    public static void merge(ListNode l1, ListNode l2){
        while(true){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if(n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public static ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head == null|| head.next== null){
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
/*        node.next.next.next.next = new ListNode(5);*/
        reorderList(node);
    }

}
