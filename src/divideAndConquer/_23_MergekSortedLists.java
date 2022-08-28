package divideAndConquer;

import java.util.PriorityQueue;

/**
 * @author Diyang Li
 * @create 2022-08-27 10:44 AM
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

        /**
         * divide and conquer O(nlogn)
         * @param lists
         * @return
         */
        public ListNode mergeKLists1(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            return divide(lists, 0, lists.length-1);
        }


        private ListNode divide(ListNode[] lists, int left, int right){
            if(left == right) return lists[left];

            int mid = left + (right - left)/2;
            ListNode leftList = divide(lists, left, mid);
            ListNode rightList = divide(lists, mid+1, right);
            return merge(leftList, rightList);
        }

        private ListNode merge(ListNode l1, ListNode l2){
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
         * priority queue
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) return null;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (ListNode node : lists) {
                if (node != null) pq.offer(node);
            }

            while (!pq.isEmpty()) {
                ListNode cur = pq.poll();
                p.next = cur;
                p = p.next;
                cur = cur.next;
                if (cur != null) pq.offer(cur);
            }

            return dummy.next;
        }
    }
}