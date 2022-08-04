package tree.template.constructAndSerialize;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-07-27 3:47 PM
 */
public class _297_SerializeandDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static StringBuilder sb = new StringBuilder();

    /**
     * preorder
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();
    }

    // this is actually a backtracking
    public static void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) sb.append("#,"); //需要对null的进行操作，不能return！！
        else {
            sb.append(root.val);
            sb.append(",");
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
    }

    public static TreeNode deserialize(String data) {
        String[] array = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(queue);
    }

    public static TreeNode rdeserialize(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("#")) return null; //不需要对null的进行操作，能return！！
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = rdeserialize(queue);
        treeNode.right = rdeserialize(queue);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);

        System.out.println(serialize(head));
    }
}
