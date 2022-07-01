package linkedList;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Diyang Li
 * @create 2022-07-01 11:10 AM
 */
public class _23_MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**                                                merget * sort
     * Divide and Conquer + 21:Merge Two Sorted List: O(nlogn)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        return sort(lists, 0, lists.length-1);
    }

    public ListNode sort(ListNode[] lists, int left, int right){
        if(left >= right){
            return lists[left];
        }

        // find the mid of the list and partition
        int mid = (right - left)/2 + left;

        ListNode l1 = sort(lists, left, mid);
        ListNode l2 = sort(lists, mid+1, right);

        // A function to merget the two list;
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * priority queue: a more general way
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        // the queue sort the node with the ascending order of the first val
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b)->a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(ListNode node: lists){
            if(node != null){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            cur.next = queue.poll(); // poll the smallest first value node
            cur = cur.next;
            if (cur.next!=null){
                queue.add(cur.next); // add the rest part of the polled node
            }
        }

        return dummy.next;
    }

}



















