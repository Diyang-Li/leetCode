import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-06-03 10:30 PM
 */
public class _116_PopulatingNextRightPointersinEachNode {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * Mine mind
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        Node curEnd = root;
        Node nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node lastNode = null;
        Node curNode = null;

        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (curNode.left != null) {
                queue.add(curNode.left);
                nextEnd = curNode.left;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nextEnd = curNode.right;
            }
            if (lastNode == null) {
                lastNode = curNode;
            } else {
                lastNode.next = curNode;
            }

            if (curNode == curEnd) {
                curNode.next = null;
                lastNode = null;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return root;
    }

    /**
     * recursion method
     * @param root
     */

    public static Node connect1(Node root){
        if (root == null){
            return null;
        }

        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(connect(head));
    }

}
