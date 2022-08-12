package tree;

/**
 * @author Diyang Li
 * @create 2022-08-11 3:16 PM
 */
public class _776_SplitBST {
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
     * si ye xie bu chu lai
     */
    TreeNode[] res = new TreeNode[2];

    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) return res;
        // root is on the right side, which means all nodes on the right side of the root are on the second tree
        // some nodes on the left side should be linked to the right tree
        if (root.val > target) {
            res = splitBST(root.left, target);
            root.left = res[1];
            res[1] = root;
        } else {
            // root.val <= target, root in the left tree, all nodes in the left tree are in the left,
            // some nodes on the right side should be linked to the left tree
            res = splitBST(root.right, target);
            root.right = res[0];
            res[0] = root;
        }

        return res;
    }
}
