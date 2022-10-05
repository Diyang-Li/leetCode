package graph.Dijkstra;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-10-04 4:45 PM
 */
public class _743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //{curNode: {nextNode, time}}
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] arr: times){
            if(!map.containsKey(arr[0])){
                map.put(arr[0], new ArrayList<>());
            }
            List<int[]> list = map.get(arr[0]);
            list.add(new int[]{arr[1], arr[2]});
            map.put(arr[0], list);
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        // arr[time, curNode]
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1]-b[1]));
        q.offer(new int[]{k, 0});

        while(!q.isEmpty()){
            int[] curInfo = q.poll();
            int curNode = curInfo[0];
            int curTime = curInfo[1];
            List<int[]> adj = map.getOrDefault(curNode, new ArrayList<>());
            for(int[] arr: adj){
                int nextNode = arr[0];
                int nextTime = arr[1];
                if(dis[nextNode] > curTime+nextTime){
                    dis[nextNode] = curTime + nextTime;
                    q.offer(new int[]{nextNode, curTime + nextTime});
                }
            }
        }
        int res = 0;
        for(int i = 1; i < dis.length; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res,dis[i]);
        }
        return res;
    }
}
