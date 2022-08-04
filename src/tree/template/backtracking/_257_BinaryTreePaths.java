package tree.template.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * backtracking
 * @author Diyang Li
 * @create 2022-08-03 11:32 AM
 */
public class _257_BinaryTreePaths {
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
     * back tracking, the information is from up to down, recommend
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        // we could put the list outside the recursion, it is the address of the reference type, so the value wouldn't change
        // although str also is a reference type, it is unchangeable
        dfs(root, String.valueOf(root.val), list);
        return list;
    }

    public void dfs(TreeNode root, String str, List<String> list){
        // the base case here is not root==null, be careful
        // when we reach the leaf node, add the path to the list
        if(root.left == null && root.right == null){
            list.add(str);
            return;
        }
        // cannot write as str = str + "->" + root.left.val, list, dfs(root.left, str, list)
        // because it's not a if-else structure, when the left side come back, we have to continue the rigth part
        // if we change the str, the str that used in right also be changed
        if(root.left != null) dfs(root.left, str + "->" + root.left.val, list);
        if(root.right != null) dfs(root.right, str+ "->"+ root.right.val, list);
        return;

    }

    /**
     * bsf one queue to record node, another one to record path
     * when meet leaf, add the path to the result list
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        // record current node
        Queue<TreeNode> q = new LinkedList<>();
        // record the path
        Queue<String> p = new LinkedList<>();

        q.offer(root);
        p.offer(Integer.toString(root.val));

        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            String item = p.poll(); // the last char of the item must be the value of cur

            // if the cur is leaf, we don't need to change the value of item, just add the item to the res
            if(cur.left == null && cur.right == null) res.add(item);
            // if left is not null, add to q and item
            if(cur.left!= null){
                q.offer(cur.left);
                p.offer(item + "->" + cur.left.val);
            }

            if(cur.right != null){
                q.offer(cur.right);
                p.offer(item + "->" + cur.right.val);
            }
        }

        return res;

    }
}
