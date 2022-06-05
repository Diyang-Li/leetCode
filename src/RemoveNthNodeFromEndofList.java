import org.w3c.dom.Node;

/**
 * @author Diyang Li
 * @create 2022-05-31 9:30 PM
 */
public class RemoveNthNodeFromEndofList {
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

/*    *//**
     * Mine  双指针暴力解决
     * @param
     * @param
     * @return
     *//*
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        while(fast.next!=null){
            fast = fast.next;
            count++;
        }

        count = count - n;

        if(count == 0){
            return slow.next;
        }else if(count < 0){
            return null;
        }else{
            for(int i = 1; i< count; i++){
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }*/

    /**
     * 优化后：这道题没有提到的boundary condition： n>head.length,如果出现这样的情况，会null pointer exception
     * @param
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //设置dummy三个作用
        //1. 如果n = head.length， 需要remove掉所有的head，直接返回dummy.next
        //2. 如果n = head.length， fast n步后会来到最后一个null，加上一个dummy可以作为一个buffer，让fast不来到null，在null前停下
        //3. 倒数第n个数从index=1开始，所以，n=2，意味着要fast往前2步的slow不remove，而是slow.nextremove，方便解题
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 快慢指针：fast走到last node，与slow间距n值，slow的下一个数就是要remove的数字
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i< n; i++){
            fast = fast.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }
    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);

        int n = 2;
        printLinkedList(node2);
        printLinkedList(removeNthFromEnd(node2, n));
    }
}
