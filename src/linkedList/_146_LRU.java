package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-12-07 4:17 PM
 */
class Node{
    Node prev;
    Node next;
    int val;
    int key;
    // 当capacity超过的时候，直接可以删除tail，而不是要先到尾部在删除，达到O(1)效果
    public Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    Node head;  //less recent
    Node tail;  //most recent
    int cap;
    int size;
    // keyvalue, pointer on the double linked list
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        // head and tail连接在一起
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        // make the this node to tail, because it is the most recently used now
        // 1. remove this node pointer  from Node
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        // 2. move to the tail
        removeTail(cur);
        // 3. return the value;
        return cur.val;
    }

    public void put(int key, int value) {

        // if the map contains the key, update val, and move to tail
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            get(key); // very smart way, do not need to write the repeating code
            return;
        }else{
            // if not add to tail directly, update the size and compare with the capacity

            if(size == cap){
                Node temp = head.next;
                head.next = temp.next;
                temp.next.prev = head;
                map.remove(temp.key);
                size--;
            }
            Node addNode = new Node(key, value);
            removeTail(addNode);
            size++;
            map.put(key, addNode);
        }
        // if not add to tail directly, update the size and compare with the capacity
    }

    // move the current Node to the tail
    private void removeTail(Node cur){
        Node temp = tail.prev;
        temp.next = cur;
        cur.prev = temp;
        cur.next = tail;
        tail.prev = cur;
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        System.out.println(l.get(2));
        l.put(2,6);
        System.out.println(l.get(1));
        l.put(1,5);
        l.put(1,2);
        System.out.println(l.get(1));
        System.out.println(l.get(2));

    }
}