package tree;

/**
 * @author Diyang Li
 * @create 2022-08-02 3:14 PM
 */
public class _1123_LowestCommonAncestorofDeepestLeaves {
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
     * method 1: calculate the depth of each tree node O(n^2)
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == right) return root;
        else if(left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    /**
     * method 2: use class to collect information O(n)
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        Pair pair = dfs(root, 0);
        return pair.node;
    }

    public Pair dfs(TreeNode root, int height){
        // if the root is null, we will add 1 to the height, cause the null node is not a leaf
        if(root == null) return new Pair(root, height);

        // template of postorder traverse: left, right, root
        Pair left = dfs(root.left, height + 1);
        Pair right = dfs(root.right, height + 1);

        if(left.height == right.height) return new Pair(root, left.height);
        else if(left.height > right.height) return left;
        else return right;
    }
    class Pair{
        int height; // height of deepest leaves;

        TreeNode node;// LCA
        public Pair(TreeNode node, int height){
            this.height = height;
            this.node = node;
        }
    }



}
