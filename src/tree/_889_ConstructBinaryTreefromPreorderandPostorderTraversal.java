package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * template 105, some tricky changes, low frequency
 * @author Diyang Li
 * @create 2022-07-29 3:41 PM
 */
public class _889_ConstructBinaryTreefromPreorderandPostorderTraversal {
    public static class TreeNode {
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
    int[] pre;
    int[] post;
    int index = 0;
    int len;
    Map<Integer, Integer> map = new HashMap();

    /**
     * template 105, some tricky change
     * @param preorder
     * @param postorder
     * @return
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;
        len = preorder.length;

        for(int i = 0; i < len; i++){
            map.put(postorder[i], i);
        }

        return helper(0, len-1);
    }

    public TreeNode helper(int left, int right){
        if(left > right) return null;


        TreeNode root = new TreeNode(pre[index++]);

        if(left == right) return root;


        int leftRoot = map.get(pre[index]);

        root.left = helper(left, leftRoot);
        root.right = helper(leftRoot+1, right-1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);

        int[] pre = {1,2,4,5,3};
        int[] post = {4,5,2,3,1};
        _889_ConstructBinaryTreefromPreorderandPostorderTraversal t = new _889_ConstructBinaryTreefromPreorderandPostorderTraversal();
        t.constructFromPrePost(pre, post);
    }
}
