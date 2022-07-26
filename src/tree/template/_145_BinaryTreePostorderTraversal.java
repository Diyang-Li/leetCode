package tree.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Post order
 *
 * @author Diyang Li
 * @create 2022-07-26 11:34 AM
 */
public class _145_BinaryTreePostorderTraversal {
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
     * method 1: use method of List, easier to understand and remember.
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            root = s.pop();
            res.add(0, root.val);

            if(root.left != null){
                s.push(root.left);
            }

            if(root.right != null){
                s.push(root.right);
            }
        }

        return res;
    }

    /**
     * method2: not recommand, easier to forget
     * @param root
     * @return
     */
    // left --> right --> head
    // 1. stack1: head --> left --> right
    // 2. stack2: head --> right --> left
    // 3. stack2 pop: left --> right --> head
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        stack1.push(root);

        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);

            if(root.left != null){
                stack1.push(root.left);
            }

            if(root.right != null){
                stack1.push(root.right);
            }
        }

        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }

        return res;
    }

}
