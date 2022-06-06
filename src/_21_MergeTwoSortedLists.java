/**
 * @author Diyang Li
 * @create 2022-06-06 10:29 AM
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
     * Recursion Way
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1 == null && list2 == null) {
            return null;
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
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(list1, list2);

    }
}
