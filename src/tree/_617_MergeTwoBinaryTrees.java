package tree;

/**
 * @author Diyang Li
 * @create 2022-08-05 3:18 PM
 */
public class _617_MergeTwoBinaryTrees {
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

    // overlap root2
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;


        root2.val = root1.val + root2.val;

        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);

        return root2;
    }
}
