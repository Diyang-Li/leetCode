package bfs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-08-22 11:22 AM
 */
public class _111_MinimumDepthofBinaryTree {
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
     * Both bfs and dfs are good, however when bfs meet the leaf node, it could return the result directly,
     * the dfs needs to traverse all the node then return, so if the left of root is null, the depth of right is
     * very deep, the dfs will waste a lot of time.
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            depth++;
        }

        return depth;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth1(root.right)+1;
        if(root.right == null) return minDepth1(root.left) + 1;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    public static void main(String[] args) {
        String str = "1#2#*#*#3#4#*#*#5#*#*#";
        String[] split = str.split("#");
        System.out.println(Arrays.toString(split));
    }
}
