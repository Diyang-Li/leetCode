package tree.template.pureRecursion;

/**
 * @author Diyang Li
 * @create 2022-08-04 9:40 AM
 */
public class _1120_MaximumAverageSubtree {
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


    double max = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        int[] arr = helper(root);
        return max;
    }

    public int[] helper(TreeNode root){
        // sum,count
        if(root == null) return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        max = Math.max((double)max, (double)sum/count);

        return new int[]{sum, count};

    }
}
