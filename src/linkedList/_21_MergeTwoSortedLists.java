package linkedList;

/**
 * @author Diyang Li
 * @create 2022-06-29 4:04 PM
 */
public class _21_MergeTwoSortedLists {
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
     * two pointer
     * O(n) O(n)
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //1. two sorted linked lists
        //2. merge with sort
        if(list1 == null && list2 == null){
            return null;
        }

        if(list1 == null) {
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        //
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            cur = cur.next; // don't forget to move the cur;
        }

        if (list1 != null){
            cur.next = list1;
        }

        if(list2 != null){
            cur.next = list2;
        }

        return dummy.next;
    }

    /**
     * recursion O(n) O(1)
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        int val1 = list1.val;
        int val2 = list2.val;

        if (val1 <= val2) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;

        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }



    public static void main(String[] args) {
        ListNode headA = new ListNode(-9);
        headA.next = new ListNode(3);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(7);

        mergeTwoLists(headA, headB);
    }
}
