package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-02 11:33 AM
 */
public class _1676_LowestCommonAncestorofaBinaryTreeIV {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * template 236
     * there is no need to consider null, so we just use the preorder template
     */
    List<TreeNode> list = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(nodes.length == 1) return nodes[0];
        for(TreeNode node: nodes){
            list.add(node);
        }

        return dfs(root);
    }

    public TreeNode dfs(TreeNode root){
        if(root == null) return null;

        if(list.contains(root)){
            return root;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);


        if(left != null && right != null) return root;
        if(left!=null) return left;
        if(right != null) return right;
        return null;
    }
}
