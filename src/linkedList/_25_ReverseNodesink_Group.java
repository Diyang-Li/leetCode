package linkedList;

import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-29 10:31 AM
 */
class ListNode {
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
public class _25_ReverseNodesink_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count < k){
            cur = cur.next;
            count++;
        }

        // if count!=k, means the rest node is not a multiple of k
        if(count == k){
            // seperate the linked list to many parts, so the count of nodes is the multiple of k
            // then reverse them seperately
            cur = reverseKGroup(cur, k);
            // k nodes need to reverse k times
            // use the iterate method to reverse the nodes, n->next of the head, cur is like prev
            while(count > 0){
                ListNode n = head.next;
                head.next = cur;
                cur = head;
                head = n;
                count--;
            }
            head = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode p = node;
        for(int i = 2; i <= 5; i++){
            p.next = new ListNode(i);
            p = p.next;
        }
        _25_ReverseNodesink_Group reverse = new _25_ReverseNodesink_Group();
        reverse.reverseKGroup(node, 3);
    }

}
