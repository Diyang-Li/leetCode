package tree.template.BST;

/**
 * @author Diyang Li
 * @create 2022-07-29 5:05 PM
 */
public class _700_SearchinaBinarySearchTree {
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
     * iteration: O(nlogn)
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        while(true){
            if(root == null){
                return null;
            }

            if(root.val > val){
                root = root.left;
            }else if (root.val < val){
                root = root.right;
            }else{
                return root;
            }
        }
    }

    /**
     * recursion
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        if(root.val < val) {
            return searchBST1(root.right, val);
        }else{
            return searchBST1(root.left, val);
        }
    }
}
