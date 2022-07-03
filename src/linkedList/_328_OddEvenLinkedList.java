package linkedList;

/**
 * @author Diyang Li
 * @create 2022-07-03 11:54 AM
 */
public class _328_OddEvenLinkedList {
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
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;

        ListNode cur = head;

        // seperate the odd and even head;
        while(cur != null){
            // oddHead
            if(oddHead == null){
                oddHead = cur;
                oddCur = oddHead;

                cur = cur.next;

            }else{
                oddCur.next = cur;
                oddCur = oddCur.next;
                cur = cur.next;

            }
            // cur has moved to the next, if the cur is null, next step will report exception
            if(cur == null){
                break;
            }

            // evenHead
            if(evenHead == null){
                evenHead = cur;
                evenCur = evenHead;

                cur = cur.next;
                // if we don't control the next node of evenHead, then the list will become cycle list
                // oddHead -> 1->3->5->7->null
                // evenHead -> 2->4-> 6-> 7 -> null
                evenCur.next = null;
            }else{
                evenCur.next = cur;
                evenCur = evenCur.next;
                cur = cur.next;
                evenCur.next = null;
            }
        }

        oddCur.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        oddEvenList(node);
    }
}
