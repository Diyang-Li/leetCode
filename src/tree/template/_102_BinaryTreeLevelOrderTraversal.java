package tree.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Traverse in level
 * @author Diyang Li
 * @create 2022-07-26 12:58 PM
 */
public class _102_BinaryTreeLevelOrderTraversal {
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

    /**
     * method 1: iteration
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            //record node in each level
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                //get the head node in queue for adding left and right to the queue
                root = queue.poll();
                level.add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }

                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    /**
     * method2: DSF
     * @param root
     * @return
     */
    // DSF
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // use height to distinguish layers
        dsf(root, res, 0);

        return res;
    }

    public void dsf(TreeNode root, List<List<Integer>> res, int height){
        if(root == null) return;
        if(height == res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(root.val);

        if(root.left != null) {
            dsf(root.left, res, height+1);
        }

        if(root.right != null){
            dsf(root.right, res, height+1);
        }
    }
}
