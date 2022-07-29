package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * template 105
 *
 * @author Diyang Li
 * @create 2022-07-29 2:18 PM
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
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

    int[] in;
    int[] post;
    int index; // record the position in inorder array;
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * use template 105, O(n)
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.in = inorder;
        this.post = postorder;
        int len = inorder.length;
        this.index = len - 1;
        // key: node in array, value: position in inorder
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        //            left, right
        return helper(0, len - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        int val = post[index];
        index--;

        TreeNode root = new TreeNode(val);

        int inRoot = map.get(val);

        // right->left because the index is a global variable
        // the postorder is from rigth to left
        root.right = helper(inRoot + 1, right);
        root.left = helper(left, inRoot - 1);

        return root;
    }
}
