package tree.template.constructAndSerialize;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-28 4:46 PM
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int[] pre;
    int[] in;
    int index = 0;

    // preorder and inorder consist of unique values, so we could put the num in inorder and its position in map, O(n^2) will become O(n)
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * use hash map to optimize the for loop process, which will help to reduce the time complex
     * this method will be preferred in the interview
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        this.pre = preorder;
        this.in = inorder;
        int len = preorder.length;
        for(int i = 0; i < len; i++){
            map.put(inorder[i], i);
        }
        // the first 0 is to record the place of current root in preorder array
        return helper1(0, len-1);
    }

    public TreeNode helper1(int left, int right){
        if(left > right) return null;

        int val = pre[index];
        index++;
        TreeNode root = new TreeNode(val);
        int inRoot = 0;
        // get the position of root in inorder by map directly
        inRoot = map.get(val);

        int leftEnd = inRoot - left;

        root.left = helper1(left, inRoot - 1);
        root.right = helper1(inRoot+1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        this.in = inorder;
        int len = preorder.length;
        // the first 0 is to record the place of current root in preorder array
        return helper(0, len-1);
    }

    public TreeNode helper(int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(pre[index++]);

        int inRoot = 0;

        for(int j = left; j <= right; j++){
            if(in[j] == root.val){
                inRoot = j;
            }
        }

        int leftEnd = inRoot - left;

        root.left = helper(left, inRoot - 1);
        root.right = helper(inRoot+1, right);

        return root;
    }
}
