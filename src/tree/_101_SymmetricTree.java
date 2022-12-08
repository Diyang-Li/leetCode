package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-08-05 3:15 PM
 */
public class _101_SymmetricTree {
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
     * template 100: compare between two trees
     * thinking: to compare right and left, just separate it into two trees
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode l, TreeNode r) {
        if (r == null && l == null) return true;
        if (r == null || l == null) return false;
        if (r.val != l.val) return false;

        boolean out = helper(l.left, r.right);
        boolean in = helper(l.right, r.left);

        return out && in;
    }
    static Map<String,Integer> map = new HashMap<>();


    public static void main(String[] args) {

            map.put("-o", 1);
            map.put("-r", 2);
            map.put("-k", 3);

        System.out.println(map.get("-k"));
    }

}
