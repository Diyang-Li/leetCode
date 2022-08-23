package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-08-22 11:55 AM
 */
public class _102_BinaryTreeLevelOrderTraversal {
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
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curRes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                curRes.add(cur.val);
            }
            res.add(curRes);
        }

        return res;
    }

    /**
     * dfs
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder1(TreeNode root) {
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode root, int h) {
        if (root == null) return;

        if (res.size() < h) {
            res.add(new ArrayList<Integer>());
        }
        res.get(h - 1).add(root.val);

        if (root.left != null) helper(root.left, h + 1);
        if (root.right != null) helper(root.right, h + 1);
    }
}
