package tree;

/**
 * @author Diyang Li
 * @create 2022-08-09 3:18 PM
 */
public class _230_KthSmallestElementinaBST {
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

    int kth = 0;
    int res = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        kth--;
        if (kth == 0) {
            res = root.val;
            return;
        }
        inorder(root.right);
    }
}
