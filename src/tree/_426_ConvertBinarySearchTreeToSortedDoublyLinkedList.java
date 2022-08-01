package tree;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-07-31 5:29 PM
 */
public class _426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first = null;
    Node prv = null;

    /**
     * method 1: recursion template inorder traverse
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        first.left = prv;
        prv.right = first;
        return first;

    }

    public void helper(Node root) {
        if (root == null) return;
        treeToDoublyList(root.left);
        if (first == null) first = root;
        if (prv != null) {
            root.left = prv;
            prv.right = root;
        }
        prv = root;
        treeToDoublyList(root.right);
    }

    /**
     * method 2: template inorder iteration, but relative slower
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList1(Node root) {
        if (root == null) return null;
        Node first = null;
        Node prv = null;
        Stack<Node> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (first == null) first = root;
            if (prv != null) {
                prv.right = root;
                root.left = prv;
            }
            prv = root;
            root = root.right;

        }

        first.left = prv;
        prv.right = first;

        return first;
    }
}
