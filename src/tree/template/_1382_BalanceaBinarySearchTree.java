package tree.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-01 10:12 AM
 */
public class _1382_BalanceaBinarySearchTree {
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
     * template: 1. inorder traverse
     *           2. 108: use bs to build a balanced BST
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return helper(list, 0, list.size()-1);
    }

    public void inorder(List<Integer> list, TreeNode root){
        if(root == null) return;

        inorder(list, root.left);
        list.add(root.val);
        inorder(list,root.right);
    }

    public TreeNode helper(List<Integer> list, int left, int right){
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, left, mid-1);
        root.right = helper(list, mid+1, right);
        return root;
    }
}
