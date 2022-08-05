package tree;

/**
 * @author Diyang Li
 * @create 2022-08-04 8:46 PM
 */
public class _111_MinimumDepthofBinaryTree {
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
     * my method
     */
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return min+1;
    }

    public void helper(TreeNode root, int height){
        if(root.left == null&& root.right == null){
            min = Math.min(min,height);
        }

        if(root.left != null) helper(root.left, height+1);
        if(root.right != null) helper(root.right, height+1);
    }
}
