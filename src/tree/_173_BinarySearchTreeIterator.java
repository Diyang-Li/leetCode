package tree;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-07-31 10:34 AM
 */
public class _173_BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> stack;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushNode(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushNode(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

    }
}
