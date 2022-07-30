package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-07-28 3:04 PM
 */
public class _1008_ConstructBinarySearchTreefromPreorderTraversal {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * template 499 method 2 most fast
     */
    int i = 0;

    public TreeNode bstFromPreorder1(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        return rbst1(preorder, Integer.MAX_VALUE);
    }

    public TreeNode rbst1(int[] arr, int bound){
        if(i >= arr.length || arr[i] > bound) return null;

        int val = arr[i];
        i++;
        TreeNode root = new TreeNode(val);

        root.left = rbst1(arr, val);
        root.right = rbst1(arr, bound);

        return root;
    }

    /**
     * template 449  method: 1
     * @param preorder
     * @return
     */
    int index = 0;
    int len;
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        len = preorder.length;
        return rbst(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode rbst(int low, int up){
        if(index == len) return null;

        int val = preorder[index];

        if(val < low || val > up) return null;
        index++;
        TreeNode root = new TreeNode(val);
        root.left = rbst(low, val);
        root.right = rbst(val, up);

        return root;
    }
}
