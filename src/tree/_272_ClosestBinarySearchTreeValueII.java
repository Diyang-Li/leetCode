package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-10 11:16 AM
 */
public class _272_ClosestBinarySearchTreeValueII {
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

    // the linkedlist like a queue
    LinkedList<Integer> res = new LinkedList<>();

    /**
     * method 1: O(n)
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        helper(root, target, k);
        return res;
    }

    public void helper(TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }

        helper(root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(target - res.peekFirst()) > Math.abs(target - root.val)) {
                res.removeFirst();
            } else return;// if the current root is not closer to the target, the rest root is becoming from teh target;
        }
        res.add(root.val);
        helper(root.right, target, k);

    }

    /**
     * method 2: O(nlogn) 暂时还没看
     * @param root
     * @param target
     * @param k
     * @return
     */

    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        iniPred(root, target, pred);
        iniSucc(root, target, succ);
        if (!pred.isEmpty() && !succ.isEmpty() && succ.peek().val == pred.peek().val) {
            helper(pred, false);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                res.add(helper(pred, false));
            } else if (pred.isEmpty()) {
                res.add(helper(succ, true));
            } else {
                double succDiff = Math.abs((double)succ.peek().val - target);
                double predDiff = Math.abs((double)pred.peek().val - target);
                if (succDiff < predDiff) {
                    res.add(helper(succ, true));
                } else {
                    res.add(helper(pred, false));
                }
            }
        }
        return res;
    }

    private void iniSucc(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void iniPred(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private int helper(Stack<TreeNode> stack, boolean isSucc) {
        TreeNode cur = stack.pop();
        int res = cur.val;

        if (isSucc) cur = cur.right;
        else cur = cur.left;

        while (cur != null) {
            stack.push(cur);
            if (isSucc) cur = cur.left;
            else cur = cur.right;
        }
        return res;
    }
}
