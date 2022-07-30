package tree.template.BST;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-07-30 5:29 PM
 */
public class _98_ValidateBinarySearchTree {
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

    long pre = Long.MIN_VALUE;

    /**
     * method 1: inorder traverse recursion, most fast
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false; // if left is false, don't need to compare the right part;
        if (root.val <= pre) return false;
        else pre = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }

    /**
     * method2 inorder traverse iteration, slower
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while(cur != null||!stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val <= pre) return false;
            pre = cur.val;
            cur = cur.right;

        }

        return true;
    }

    /**
     * method 3, use boundary
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        // when root comes to left, max is not available
        // when root comes to right, min is not available
        if(max !=  null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
