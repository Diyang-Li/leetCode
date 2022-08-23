package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-08-23 8:33 AM
 */
public class _490_TheMaze {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]) return true;

            for(int[] dir: dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                // cannot out of bounds and the num at [x,y] should be 0
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }

                x -= dir[0]; // back one step, because the x has reached the wall
                y -= dir[1];

                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }

}
