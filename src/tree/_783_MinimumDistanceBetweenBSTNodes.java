package tree;

/**
 * @author Diyang Li
 * @create 2022-08-11 3:44 PM
 */
public class _783_MinimumDistanceBetweenBSTNodes {
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

    int diff = Integer.MAX_VALUE;
    int pre = -1;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;

        minDiffInBST(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            diff = Math.min(diff, Math.abs(root.val - pre));
            pre = root.val;
        }

        minDiffInBST(root.right);

        return diff;
    }
}
