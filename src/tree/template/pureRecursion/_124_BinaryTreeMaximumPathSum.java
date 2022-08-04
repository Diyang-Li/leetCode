package tree.template.pureRecursion;

/**
 * @author Diyang Li
 * @create 2022-08-03 7:30 PM
 */
public class _124_BinaryTreeMaximumPathSum {
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

    // we wanna calculate the child first then treat the result, so use the postorder template
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recur(root);
        return max;
    }


    public int recur(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, recur(root.left)); // if the node is smaller then 0, null node return 0, just use 0, like cut the node
        int right = Math.max(0, recur(root.right));
        // when we calculate current node and its child nodes[20, 15, 7]
        max = Math.max(max, left + right + root.val);
        // when we want to return the sum to parent: [20, 15]
        return Math.max(left, right) + root.val;
    }
}
