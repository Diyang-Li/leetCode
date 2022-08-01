package tree;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-07-31 7:49 PM
 */
public class _99_RecoverBinarySearchTree {
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

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prv = new TreeNode(Integer.MIN_VALUE);

    /**
     * method 1: inorder traverse with some tricky methods to find the wrong numbers
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        find(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        // cannot write <= because there is MIN_VALUE in test case, if the minium value is MIN_VAL in the tree,
        // but on the right position, it will marked as the first wrong node
        if(root.val < prv.val) {
            if(first == null){
                first = prv;
                // why: because when the inorder[1,3,2,4] we could mark the second wrong num
                // if not write this, pre -> 3, root -> 2 ----> pre -> 2, root -> 4 it is increase
                // so we lost the chance to mark the second wrong node
                second = root;
            }else{
                second = root;
            }
        }
        prv = root;

        find(root.right);
    }

    /**
     * method 2: inorder traverse template: slower
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        if(root == null) return;

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prv = new TreeNode(Integer.MIN_VALUE);

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //[1,3,2,4]
            if(root.val < prv.val) {
                if(first == null){
                    first = prv;
                    second = root;
                }else{
                    second = root;
                }
            }

            prv = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

}
