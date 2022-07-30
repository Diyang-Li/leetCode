package tree.template.BST;

/**
 * @author Diyang Li
 * @create 2022-07-30 10:45 AM
 */
public class _701_InsertintoaBinarySearchTree {
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
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }

        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
