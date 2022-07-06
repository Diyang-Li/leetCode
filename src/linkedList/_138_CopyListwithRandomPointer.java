package linkedList;

import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-07-05 8:10 PM
 */
public class _138_CopyListwithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * use hashmap O(n) O(n)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // store the origin node and copy node
        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;

        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // make the value point to the right next and random
        cur = head;
        while(cur != null){
            // copy node.next --> orgin node.next;
            map.get(cur).next = map.get(cur.next);
            // copy node.random --> origin node.ramdom;
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
