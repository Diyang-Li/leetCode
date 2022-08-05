package tree.template.pureRecursion;

/**
 * @author Diyang Li
 * @create 2022-08-04 11:31 AM
 */
public class _1372_LongestZigZagPathinaBinaryTree {
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

    /**
     * there is a second  method that I cannot accept
     */
    int max = 0;

    public int longestZigZag(TreeNode root) {
        helper(root, true);
        return max;
    }


    public int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;

        int left = helper(root.left, true);
        int right = helper(root.right, false);

        max = Math.max(max, Math.max(left, right));

        if (isLeft) return right + 1;
        else return left + 1;
    }
}
