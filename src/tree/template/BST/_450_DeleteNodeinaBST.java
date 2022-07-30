package tree.template.BST;

/**
 * @author Diyang Li
 * @create 2022-07-30 12:59 PM
 */
public class _450_DeleteNodeinaBST {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findSucc(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;

    }

    public int findSucc(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }

}
