package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-07-26 4:27 PM
 */
public class _107_BinaryTreeLevelOrderTraversalII {
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
     * use BSF, template102
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // don't write queue.size() here, because the size of queue will change in the for loop
            for(int i = 0; i < size; i++){
                root = queue.poll();
                level.add(root.val);

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            // add the level to res from first position
            // res.add(level)
            res.add(0, level);
        }

        //  Collections.reverse(res);
        //        return res; It seems faster, but not actually in leetcode, not sure, can be a optimization

        return res;
    }
}
