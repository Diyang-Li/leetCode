package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Diyang Li
 * @create 2022-08-02 10:08 AM
 */
public class _1650_LowestCommonAncestorofaBinaryTreeIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    /**
     * brute force
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();

        while(p!=null || q!=null){
            if(p != null && !set.add(p)) return p;
            if(q != null && !set.add(q)) return q;
            if(p != null) p = p.parent;
            if(q != null)q = q.parent;
        }

        return null;
    }

    /**
     * use node intersection, the parent as pointer, method 1
     * template 160
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor1(Node p, Node q) {
        Node pn = p;
        Node qn = q;

        int count = 0;

        while(pn != null){
            pn = pn.parent;
            count++;
        }

        while(qn != null){
            qn = qn.parent;
            count--;
        }

        // let the pn point to the longer one;
        pn = count>0? p: q;
        qn = pn == p? q: p;

        count = Math.abs(count);

        while(count!=0){
            count --;
            pn = pn.parent;
        }

        while(pn!=qn){
            pn = pn.parent;
            qn = qn.parent;
        }

        return qn;

    }

    /**
     * when any of them reach the null, go back to the start point to build a cycle
     * use the linked list cycle: template 141
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor2(Node p, Node q) {
        Node pn = p;
        Node qn = q;

        //build cycle
        while(pn != qn){
            pn = pn == null? p: pn.parent;
            qn = qn == null? q: qn.parent;
        }

        return pn;
    }

}
