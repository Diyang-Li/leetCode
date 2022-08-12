package tree;

/**
 * https://www.bilibili.com/video/BV1WQ4y1Z7vf?spm_id_from=333.337.search-card.all.click&vd_source=82c20631d4fe5c73eeeb14130d72a5be
 * @author Diyang Li
 * @create 2022-08-11 11:02 AM
 */
public class _669_TrimaBinarySearchTree {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) return trimBST(root.right, low, high);
        else if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
