package tree.template.pureRecursion;

/**
 * @author Diyang Li
 * @create 2022-08-04 4:34 PM
 */
public class _549_BinaryTreeLongestConsecutiveSequenceII {
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

    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int in = 1;
        int de = 1;

        if (root.left != null) {
            int[] left = helper(root.left);
            if (root.val == root.left.val + 1) in = 1 + left[0];
            if (root.val == root.left.val - 1) de = 1 + left[1];
        }

        if (root.right != null) {
            int[] right = helper(root.right);
            // have to compare the left and right
            if (root.val == root.right.val + 1) in = Math.max(in, 1 + right[0]);
            if (root.val == root.right.val - 1) de = Math.max(de, 1 + right[1]);
        }
        res = Math.max(res, in + de - 1);
        return new int[]{in, de};
    }

}
