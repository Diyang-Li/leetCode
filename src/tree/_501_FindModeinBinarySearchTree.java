package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-08-09 11:05 AM
 */
public class _501_FindModeinBinarySearchTree {
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
     * method1:
     * method2: can use morris to reduce the space O(n) -> O(1), didn't learn
     */
    List<Integer> list = new ArrayList<>();
    int maxCount = 0;
    int curCount = 0;
    int curNode = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];

        helper(root);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;

    }

    // inorder traverse
    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        update(root.val);
        helper(root.right);
    }


    // update the emlement in the res list
    public void update(int i){
        if(curNode == i){
            curCount++;
        }else{
            curNode = i;
            curCount = 1;
        }

        if(curCount == maxCount) {
            list.add(i);
        }
        if(curCount > maxCount){
            maxCount = curCount;
            list.clear();
            list.add(i);
        }
    }
}
