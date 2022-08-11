package tree;

/**
 * @author Diyang Li
 * @create 2022-08-10 9:22 AM
 */
public class _270_ClosestBinarySearchTreeValue {
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
     * recursion
     */
    double diff = Integer.MAX_VALUE;
    int res = 0;

    public int closestValue(TreeNode root, double target) {
        help(root, target);
        return res;
    }

    public void help(TreeNode root, double target) {
        if (root == null) return;

        double curDiff = Math.abs(root.val - target);
        if (curDiff < diff) {
            diff = curDiff;
            res = root.val;
        }

        if (target < root.val) help(root.left, target);
        if (target > root.val) help(root.right, target);
    }

    /**
     * iteration
     * @param root
     * @param target
     * @return
     */
    public int closestValue1(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
