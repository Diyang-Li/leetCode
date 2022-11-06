package linkedList;

import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;

/**
 * @author Diyang Li
 * @create 2022-06-28 12:18 PM
 */
public class _92_ReverseLinkedListII {
    public static int pos = 1;

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return null;
        }
        // use the method like reverse linked list;
        ListNode cur = head;
        ListNode prv = null;

        while (left > 1){
            prv = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // conne record the position of the left position 1 in the 12345null
        ListNode conn = prv;
        // tail record the position of the 2 in 12345null, which is the last position of reversed linked list
        ListNode tail = cur;

        while (right > 0){
            ListNode next = cur.next;
            cur.next = prv;
            prv = cur;
            cur = next;
            right--;
        }

        if (conn!=null){
            conn.next = prv;
        }else{
            head = prv; // just the reverse list;
        }
        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//
//        ListNode listNode = reverseBetween(node, 2, 4);
//        while (listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        String s = "Some words are: \"one\", \"02\", and \"three\"" + System.lineSeparator();
        System.out.println(s);
    }
}
