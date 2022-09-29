package disjointSet_unionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-09-28 4:35 PM
 */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        //   num       position
        Map<Integer, Integer> map = new HashMap<>();

        DSU dsu = new DSU(nums.length);
        // the number in nums can be negative, so we need to union the position
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(map.containsKey(cur)){
                continue;
            }
            map.put(nums[i], i);

            if(map.containsKey(cur+1)){
                dsu.union(map.get(cur+1), i);
            }
            if(map.containsKey(cur-1)){
                dsu.union(i, map.get(cur-1));
            }
        }

        return dsu.getMax();
    }
}

class DSU{
    int[] parent;
    int[] size;

    public DSU(int len){
        parent = new int[len];
        size = new int[len];
        for(int i = 0; i < len; i++){
            parent[i] = i;
        }

        Arrays.fill(size, 1);
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return;
        }
        // x -> y
        if(size[px] <= size[py]){
            parent[px] = py;
            size[py] += size[px];
        }else{
            parent[py] = px;
            size[px] += size[py];
        }
    }

    public int getMax(){
        int max = 0;
        for(int i: size){
            max = Math.max(max, i);
        }
        return max;
    }
}


