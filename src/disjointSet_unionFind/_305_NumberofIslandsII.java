package disjointSet_unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-09-27 10:27 AM
 */
public class _305_NumberofIslandsII {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m, n);
        boolean[][] isIsland = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for(int[] arr: positions){
            // to avoid operation repeatly
            int x = arr[0];
            int y = arr[1];
            if(isIsland[x][y]){
                res.add(count);
                continue;
            }
            isIsland[x][y] = true;
            count++;
            for(int i = 0; i < 4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx >= 0 && cy >= 0 && cx < m && cy < n && isIsland[cx][cy]){
                    if(uf.union(cx*n+cy, x*n+y)){
                        count--;
                    }
                }
            }

            res.add(count);
        }

        return res;
    }
}

class UnionFind{
    int[] parent;

    public UnionFind(int m, int n){
        parent = new int[m*n];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    //x -> y
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return false;
        }else{
            parent[find(x)] = find(y);
            return true;
        }

    }
}
