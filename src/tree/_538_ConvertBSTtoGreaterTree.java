package tree;

/**
 * @author Diyang Li
 * @create 2022-08-11 11:25 AM
 */
public class _538_ConvertBSTtoGreaterTree {
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

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null)
            return parentVal;
        root.val += dfs(root.right, parentVal);
        return dfs(root.left, root.val);
    }
}
