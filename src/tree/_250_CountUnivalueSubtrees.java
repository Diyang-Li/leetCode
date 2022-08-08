package tree;

/**
 * @author Diyang Li
 * @create 2022-08-07 7:10 PM
 */
public class _250_CountUnivalueSubtrees {
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

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    public boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }

            if (root.right != null && root.val != root.right.val) {
                return false;
            }

            // left == null && right == null return true;
            // (left == null) && (root.right!=null && root.val == root.right.val)
            // (right == null) && (root.left != null && root.val == root.left.val)
            // (root.left != null && root.val == root.left.val) && (root.right!=null && root.val == root.right.val)
            count++;
            return true;
        }

        return false;
    }
}
