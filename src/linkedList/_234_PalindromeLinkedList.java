package linkedList;

import java.security.PublicKey;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-07-02 9:42 PM
 */
public class _234_PalindromeLinkedList {
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
     * reverse the palindrom part, and compare from the first one
     * 1221 --> 1212
     * 12321 --> 12312
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // find the mid position
        int count = 0;
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            count++;
        }

        int mid = count/2;

        //let the cur come to the mid position
        cur = head;

        for(int i = 0; i<mid; i++){
            cur = cur.next;
        }

        // next point to the posiont that need to be reversed
        ListNode next = reverse(cur.next);
        cur.next = next;
        cur = head;

        //i=mid because 1 2, the mid point is 0, if i < mid, we will just return ture
        for(int i = 0; i<=mid; i++){
            // next == null means the end of the loop
            if(next == null){
                break;
            }
            if(cur.val != next.val){
                return false;
            }
            cur = cur.next;
            next = next.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode middle = findMid(head);
        middle.next = reverse(middle.next);

        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;

    }

    public static ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
/*        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);*/
//        node.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome2(node));
    }
}
