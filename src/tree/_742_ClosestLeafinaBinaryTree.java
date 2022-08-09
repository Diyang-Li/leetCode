package tree;

/**
 * This problem should use graph
 * @author Diyang Li
 * @create 2022-08-08 7:19 PM
 */

public class _742_ClosestLeafinaBinaryTree {
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
     * 1. find the target node
     * 2. find closet leaf in the subtree that root is target node
     * 3. find distance from the target to the leaf node of another parent child
     */
    int minRoot;
    int minPath;

    public int findClosestLeaf(TreeNode root, int k) {
        minRoot = root.val;
        minPath = Integer.MAX_VALUE;

        findK(root, k);

        return minRoot;
    }

    public int findK(TreeNode root, int k){
        if(root == null) return -1;
        if(root.val == k){
            // find leaf in the root.val == k subtree
            findLeaf(root, 0);
            return 1; // 1 means find the k and stop at here
        }

        int left = findK(root.left, k);
        int right = findK(root.right, k);

        // we have already found the leaf in the root.left/right.val == k subtree
        if(left > 0){
            // so start to find the right of the root
            findLeaf(root.right, left+1);  // leaf it the distance from target node to parent, 1 is the parent to parent.right
            return left + 1; // + 1 means I am going to the parent node of current node, so the distance + 1 to the target node
        }

        if(right > 0){
            findLeaf(root.left, right + 1);
            return right + 1;
        }

        return -1;
    }

    public void findLeaf(TreeNode root, int h){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(minPath > h){
                minPath = h;
                minRoot = root.val;
            }
        }

        findLeaf(root.left, h+1);
        findLeaf(root.right, h+1);
    }
}
