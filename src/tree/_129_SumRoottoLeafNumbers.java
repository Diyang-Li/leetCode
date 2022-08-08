package tree;

/**
 * @author Diyang Li
 * @create 2022-08-07 11:00 AM
 */
public class _129_SumRoottoLeafNumbers {
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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int res) {
        if (root == null) return 0;

        // when come to leaf
        if (root.left == null && root.right == null) {
            return res * 10 + root.val;
        }

        int left = helper(root.left, res * 10 + root.val);
        int right = helper(root.right, res * 10 + root.val);

        return left + right;
    }
}
