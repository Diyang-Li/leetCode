package tree.template.LCA;

/**
 * key point:
 * 1.when root in [p, q] we could return
 * 2. both are O(n) because some trees only has subtree on unique direction
 * @author Diyang Li
 * @create 2022-08-01 11:12 AM
 */
public class _235_LowestCommonAncestorofaBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * template 1: recursion
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        // (p <= root <= q && q <= root <= q)
        else return root;
    }

    /**
     * template: iteration
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
    }

}
