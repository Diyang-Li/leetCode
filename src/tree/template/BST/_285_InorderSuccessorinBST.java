package tree.template.BST;

import java.util.Stack;

/**
 * 但凡不是一开始最左边的node,需要返回root，都找先找到target node， 然后一路向左，找最左的值
 *
 * @author Diyang Li
 * @create 2022-08-09 12:50 PM
 */
public class _285_InorderSuccessorinBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * method 1: template slower but easy to understand
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !s.isEmpty()){
            while(cur!=null){
                s.push(cur);
                cur = cur.left;
            }

            cur = s.pop();
            if(pre!=null && pre.val == p.val){
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }

        return cur;
    }
}
