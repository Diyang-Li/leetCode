package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * DSF + BSF: template 102
 * @author Diyang Li
 * @create 2022-07-27 9:31 AM
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i= 0; i < size; i++){
                root = queue.poll();
                // the size of the queue can be used to calcualte the height of the tree
                if(res.size()%2 == 0){
                    level.add(root.val);
                }else{
                    level.add(0, root.val);
                }

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
     * DFS
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, int height){
        if(root == null){
            return;
        }

        if(res.size() == height){
            res.add(new ArrayList<Integer>());
        }

        if(height % 2 == 0){
            res.get(height).add(root.val);
        }else{
            res.get(height).add(0, root.val);
        }

        dfs(root.left, res, height+1);
        dfs(root.right, res, height+1);
    }
}