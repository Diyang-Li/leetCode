package tree;

/**
 * @author Diyang Li
 * @create 2022-08-05 4:27 PM
 */
public class _112_PathSum {
    public static class TreeNode {
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
     * method 2
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(targetSum == root.val) return true;
        }

        boolean left = hasPathSum1(root.left, targetSum - root.val);
        boolean right = hasPathSum1(root.right, targetSum - root.val);

        return left||right;
    }

}
