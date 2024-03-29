package tree;

/**
 * @author Diyang Li
 * @create 2022-08-08 12:21 PM
 */
public class _563_BinaryTreeTilt {
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

    int sum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    // post order
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        sum += Math.abs(left - right);

        return left + right + root.val;

    }
}
