package linkedList;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-29 11:59 AM
 */
public class _160_IntersectionofTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode pA = headA;
        ListNode pB = headB;

        // find the shorter one
        while(pA != null && pB != null){
            pA = pA.next;
            pB = pB.next;
            countA++;
            countB++;
        }

        while(pA != null){
            pA = pA.next;
            countA++;
        }

        while (pB != null){
            pB = pB.next;
            countB++;
        }

        int diff = Math.abs(countA - countB);

        // find the longer one and shorter one;


        ListNode longNode = countA> countB? headA:headB;
        ListNode shortNode = countA > countB? headB:headA;

        while (diff > 0){
            longNode = longNode.next;
            diff--;
        }

        while (longNode != null && longNode!= shortNode){
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return longNode;
    }

    /**
     * Better code: thinking is almost the same, but code looks more clean
     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode n1 = headA;
        ListNode n2 = headB;

        int n = 0;

        while (n1 != null){
            n++;
            n1 = n1.next;
        }

        while (n2 != null){
            n--;
            n2 = n2.next;
        }

        if(n1 != n2){
            return null;
        }

        n1 = n>0? headA: headB;
        n2 = n1==headA? headB: headA;

        n = Math.abs(n);

        while (n!=0){
            n--;
            n1 = n1.next;
        }

        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);

        System.out.println(getIntersectionNode(headA, headB));
    }
}
