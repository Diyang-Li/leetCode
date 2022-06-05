import javax.swing.tree.TreeNode;

/**
 * @author Diyang Li
 * @create 2022-06-03 8:50 PM
 */
public class _617_MergeTwoBinaryTrees {
    /**
     * 第一次尝试非递归 inorder 分别相加，失败，引文没办法处理null地方赋另外一颗树的Node
     * 下次可以试试重新构建新树，可能会更简单一些
     */

    //Definition for a binary tree node.
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
     * 答案使用recursion方法，构造一棵新树
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode tree = new TreeNode(root1.val + root2.val);
        tree.left = mergeTrees(root1.left, root2.left);
        tree.right = mergeTrees(root1.right, root2.right);

        return tree;
    }
}
