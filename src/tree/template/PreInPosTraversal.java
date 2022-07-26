package tree.template;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.util.Stack;
import java.util.logging.Level;

/**
 * @author Diyang Li
 * @create 2022-04-25 10:10 PM
 */
public class PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * recure的就是分别print 1，2，3
     * @param head
     */
    private static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(" " + head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    private static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(" " + head.value);
        inOrderRecur(head.right);
    }

    private static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
//头 左 右
    // stack [you, zuo]-->t, zuo, you
    private static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
// s1 = []
    //s2  = [t,y,z] -- z, y , t
    private static void posOrderUnRecur1(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * Only need one stack, one pointer,用一个head指针来记录曾经走过的痕迹
     * @param h
     */
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();

    }

    /**
     * 这个写法和前面不一样，不是放进head.left
     * 因为要避免比较left，这样很难做到，和post不一样, post要先等print右边才能print头，
     * 好像这种不提前放进queue/stack的就这一个
     * 但是in的即时弹出
     * @param head
     */
    // zuo tou you
    // stack = [1,5] --> print: 4 2
    // head = 5
    private static void inOrderUnRecur(Node head) {
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head!=null){
            if (head!=null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        // 5 3 2 1 4 8 7 6 10 9 11
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        // 1 2 3 4 5 6 7 8 9 10 11
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        //1 2 4 3 6 7 9 11 10 8 5
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.print("pos-order1: ");
        posOrderUnRecur1(head);
        System.out.print("pos-order2: ");
        posOrderUnRecur2(head);
    }

}
