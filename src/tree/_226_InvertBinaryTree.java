package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-08-05 12:32 PM
 */
public class _226_InvertBinaryTree {
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
     * dfs: after remained
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    /**
     * bfs: slower
     * @param root
     * @return
     */

    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode res = root;

        while(!q.isEmpty()){
            root = q.poll();
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            if(root.left != null) q.offer(root.left);
            if(root.right != null) q.offer(root.right);
        }

        return res;
    }

}
