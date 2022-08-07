package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Diyang Li
 * @create 2022-08-06 11:23 AM
 */
public class _113_PathSumII {

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

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> q = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return res;
    }

    public void helper(TreeNode root, int target) {
        if (root == null) return;

        q.offerLast(root.val);
        target -= root.val;
        // come to the leaf
        if (root.left == null & root.right == null && target == 0) {
            res.add(new ArrayList<Integer>(q));
        }

        helper(root.left, target);
        helper(root.right, target);

        // after treat left and right child, remove the node from queue
        q.pollLast();
    }

    public static void main(String[] args) {

    }
}
