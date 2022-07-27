package tree.template;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-07-27 11:13 AM
 */
public class _987_VerticalOrderTraversalofaBinaryTree {
      public static class TreeNode {
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
     * answer
     * @param root
     * @return
     */
    public static List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        for(int[] node: nodes){
            System.out.println(Arrays.toString(node));
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    public static void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }

    /**
     * my method, slower
     * @param root
     * @return
     */
    // dfs
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        //  offset     [depth, val of Node]
        Map<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> res = new ArrayList<>();

        for(List<int[]> nodes: map.values()){
            List<Integer> level = new ArrayList<>();
            Collections.sort(nodes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]){
                        return o1[1]-o2[1];
                    }else
                        return o1[0] - o2[0];
                }
            });
            for(int[] node: nodes){
                level.add(node[1]);
            }

            res.add(level);
        }

        return res;

    }

    public static void dfs(TreeNode root, int offset, int depth, Map<Integer, List<int[]>> map){
        if(root == null) return;

        if(!map.containsKey(offset)) map.put(offset, new LinkedList<int[]>());
        // put the current depth into array of LinkedList
        map.get(offset).add(new int[]{depth, root.val});

        dfs(root.left, offset-1, depth+1, map);
        dfs(root.right, offset+1, depth+1, map);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(2);
        head.right.left = new TreeNode(2);

        System.out.println(verticalTraversal1(head));
    }
}
