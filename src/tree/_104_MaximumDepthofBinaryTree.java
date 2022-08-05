package tree;

/**
 * @author Diyang Li
 * @create 2022-08-04 8:44 PM
 */
public class _104_MaximumDepthofBinaryTree {
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
    int deep = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return deep;
    }

    public void helper(TreeNode root, int heigh){
        if(root == null) {
            deep = Math.max(deep,heigh);
        }

        if(root != null) helper(root.left, heigh + 1);
        if(root != null) helper(root.right, heigh + 1);

    }

    /**
     * method 2
     * @param root
     * @return
     */

    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }
}
