package tree.template.LCA;

/**
 * although template 236, still some changes
 *
 * @author Diyang Li
 * @create 2022-08-01 7:32 PM
 */
public class _1644_LowestCommonAncestorofaBinaryTreeII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // the count here is to record if we have met all p q in the tree,
    // if not, return null;
    int count = 2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root, p, q);
        return count == 0 ? lca : null;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // why we don't use root == q || root == p likes template 236?
        // in the 236 problem,we have already knows there are two p q in the root, so we just use the template like
        // inorder recursion, see the root
        // however, in this problem, we need to see all the root, so we could use the template like post order
        // see the left and right first, then treat the root and consider the return value;
        if (root == null) return null;
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == q || root == p) {
            count--;
            return root;
        }
        if (left != null & right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;

    }

}
