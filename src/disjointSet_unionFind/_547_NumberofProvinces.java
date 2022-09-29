package disjointSet_unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-09-27 3:17 PM
 */
public class _547_NumberofProvinces {
    //BFS
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //We increment the countcount of connected components whenever we need to start off with a
        //new node as the root node for applying BFS which hasn't been already visited.
        int[] visit = new int[row];


        for(int i = 0; i < row; i++){
            if(visit[i] != 1){
                // this means start a point
                q.add(i);
                count++;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    visit[cur] = 1;
                    for(int j = 0; j < row; j++){
                        // find all point connedted to the cur
                        if(isConnected[cur][j] == 1 && visit[j] != 1){
                            q.offer(j);
                        }
                    }
                }
            }
        }

        return count;
    }

    //DFS
    public int findCircleNum2(int[][] isConnected) {
        int len = isConnected.length;
        int[] visit = new int[len];
        int count = 0;

        for(int i = 0; i < len; i++){
            if(visit[i] == 0){
                dfs(isConnected, visit, i, len);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int[] visit, int i, int len){
        for(int j = 0; j < len; j++){
            if(isConnected[i][j] == 1 && visit[j] == 0){
                visit[j] = 1;
                dfs(isConnected, visit, j, len);
            }
        }
    }

    //Union Find
    public int findCircleNum1(int[][] isConnected) {
        int row = isConnected.length;
        UF547 uf = new UF547(row);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < row; j++){
                if(isConnected[i][j] == 1){
                    uf.union(j, i);
                }
            }
        }

        int[] unioned = uf.getParent();
        int res = 0;
        for(int i = 0; i< row; i++){
            if(unioned[i] == i){
                res++;
            }
        }

        return res;
    }
}

class UF547{
    int[] parent;

    public UF547(int row){
        parent = new int[row];
        for(int i = 0; i < row; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x) {
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
        parent[px] = py;
    }

    public int[] getParent(){
        return parent;
    }
}

