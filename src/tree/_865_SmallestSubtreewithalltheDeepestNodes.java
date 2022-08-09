package tree;

/**
 * /**
 * same as 1123
 * @author Diyang Li
 * @create 2022-08-02 4:25 PM
 */
public class _865_SmallestSubtreewithalltheDeepestNodes {
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
    // The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
    // means LCA

    /**
     * method
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == right) return root;
        if (left > right) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }

    /**
     * use a class to collect information from nodes
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest1(TreeNode root) {
        Pair pair = dfs(root, 0);
        return pair.node;
    }
    public Pair dfs(TreeNode root, int height){
        if(root == null) return new Pair(null, height);
        // collect information from left and right child
        Pair left = dfs(root.left, height + 1);
        Pair right = dfs(root.right, height + 1);

        if(left.height == right.height) return new Pair(root, left.height);
        else if(left.height > right.height) return left;
        else return right;

    }
    // collect the information of  subtree to find the smallest subtree
    class Pair{
        TreeNode node;
        int height; // deepest height of current node
        public Pair(TreeNode node, int height){
            this.node = node;
            this.height = height;
        }

    }
}
