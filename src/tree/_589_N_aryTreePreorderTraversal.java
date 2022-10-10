package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-10-09 4:24 PM
 */
public class _589_N_aryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // O(n) O(n)
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, Node root){
        if(root == null){
            return;
        }

        res.add(root.val);
        for(Node child: root.children){
            dfs(res, child);
        }
    }

    // iteration not a good method
    //
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node cur =stack.pop();
            res.add(cur.val);
            List<Node> child = cur.children;
            Collections.reverse(child);
            for(Node c: child){
                stack.push(c);
            }
        }

        return res;
    }
}
