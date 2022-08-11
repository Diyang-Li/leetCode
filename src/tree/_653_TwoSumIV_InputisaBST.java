package tree;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Diyang Li
 * @create 2022-08-10 3:59 PM
 */
public class _653_TwoSumIV_InputisaBST {
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
     * method 1
     */
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        if (set.contains(root.val)) return true;
        else set.add(k - root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /**
     * method 2: two pointers in BFS
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget1(TreeNode root, int k) {
        if(root == null) return false;

        Deque<TreeNode> ld = new LinkedList<>();
        Deque<TreeNode> rd = new LinkedList<>();
        TreeNode cur = root;

        // put the left part in to the ld
        while(cur != null) {
            ld.addLast(cur);
            cur = cur.left;
        }
        // put the left part in to the rd
        cur = root;
        while(cur != null){
            rd.addLast(cur);
            cur = cur.right;
        }
        // both deque cannot be null, at least has root;
        int l = ld.peekLast().val; //left pointer
        int r = rd.peekLast().val; // right pointer

        // both value are belongs to different nodes
        while(l < r){
            int res = l + r;
            if(res == k){
                return true;
            }

            // have to move the left pointer, wanna to find a larger one
            if(res < k){
                l = getNext(ld, true);
            }else{
                r = getNext(rd, false);
            }
        }

        return false;
    }

    private int getNext(Deque<TreeNode> d, boolean isLeft){
        TreeNode node = isLeft? d.pollLast().right: d.pollLast().left;
        // the node is not the end of a path
        while(node != null){
            d.addLast(node);
            // if isLisf: have already come to the right, all the nodes on right are larger
            // then the curnode, so find the val from the smallest(most left node);
            node = isLeft? node.left: node.right;
        }

        return d.peekLast().val;
    }

}
