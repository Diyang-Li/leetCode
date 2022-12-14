package monotoneQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-12-14 12:30 PM
 */
public class _621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // decreasing order
        // 0: char num  1: frequency
        // decreasing为了减少idle时间
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // frequency and get the largetst arr
        int[] arr = new int[26];
        for(char c: tasks){
            arr[c-'A']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                pq.offer(arr[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0; // 时间流逝
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            // 如果pq不是empty，意味着有task可以运行，不是idle
            if(!pq.isEmpty()){
                int curTask = pq.poll();
                curTask--;
                if(curTask != 0){
                    // 下次可以运行同一个task的时间
                    q.offer(new int[]{curTask, time+n});
                }
            }
            // 把需要cooldown的task放进q，然后时间到了放回pq等待运行
            if(!q.isEmpty()){
                int[] readyTask = q.peek();
                if(readyTask[1] == time){
                    q.poll();
                    pq.offer(readyTask[0]);
                }
            }
        }
        return time;

    }
}
