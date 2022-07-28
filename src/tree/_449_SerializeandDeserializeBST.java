package tree;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-07-28 9:59 AM
 */
public class _449_SerializeandDeserializeBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return rserialize(root, sb).toString();
    }

    public static StringBuilder rserialize(TreeNode root, StringBuilder sb){
        if(root == null) return null;
        sb.append(root.val);
        sb.append(",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] array = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static TreeNode rdeserialize(Queue<String> q, int lower, int upper){
        if(q.isEmpty()) return null;

        String s = q.peek();
        int val = Integer.parseInt(s);

        if(val < lower || val > upper) return null;

        q.poll();
        TreeNode root = new TreeNode(val);

        root.left = rdeserialize(q, lower, val);
        root.right = rdeserialize(q, val, upper);

        return root;
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize1(String data) {
        if(data == null || data.length() == 0) return null;

        String[] strs = data.split(",");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }


        return rdeserialize1(arr, Integer.MAX_VALUE);
    }

    /**
     * method2
     */
    // helpt to traverse the arr and comparation
    static int i = 0;
    public static TreeNode rdeserialize1(int[] arr, int bound){
        if(i >= arr.length || arr[i] < bound) return null;

        TreeNode root = new TreeNode(arr[i]);
        i++;
        root.left = rdeserialize1(arr, root.val);
        root.right = rdeserialize1(arr, bound);
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(0);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(7);

        String serialize = serialize(head);

        System.out.println(deserialize1(serialize));
    }
}
