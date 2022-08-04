package tree.template.backtracking;

/**
 * @author Diyang Li
 * @create 2022-08-03 3:57 PM
 */
public class _1448_CountGoodNodesinBinaryTree {
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

    int count = 0;

    /**
     * firs time solve backtracking problem
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        back(root, root.val);
        return count;
    }

    // if the node is a good, which mush greater the largest nums in the path
    public void back(TreeNode root, int max){
        if(root.val >= max){
            max = root.val;
            count++;
        }

        if(root.left != null) back(root.left, max);
        if(root.right != null) back(root.right,max);

    }
}
