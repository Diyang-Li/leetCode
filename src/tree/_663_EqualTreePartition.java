package tree;

/**
 * @author Diyang Li
 * @create 2022-08-08 11:09 AM
 */
public class _663_EqualTreePartition {
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

    int sum = Integer.MIN_VALUE; // cannot be 0 here, because if the root is 0, then flag will be true;
    boolean flag = false;
    public boolean checkEqualTree(TreeNode root) {
        sum = calSum(root);
        calSum(root.left);
        calSum(root.right);

        return flag;
    }

    public int calSum(TreeNode root){
        if(root == null) return 0;


        int left =  calSum(root.left);
        int right = calSum(root.right);

        int curSum = root.val + left + right;
        if(curSum == (double)sum/2) {
            flag = true;
        }

        return curSum;
    }
}
