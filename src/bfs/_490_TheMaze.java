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

    int[] mx = {0,0,1,-1};
    int[] my = {1,-1,0,0};
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        return dfs(maze, start, destination, visited, row, col);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited, int row, int col){
        int x = start[0];
        int y = start[1];
        // 如果visited过的话，能来到这一步，说明不是destination， 而且这个点的4 个方向都没有路了
        if(visited[x][y]){
            return false;
        }
        if(x == destination[0] && y == destination[1]){
            return true;
        }
        //既不是visited过，又不是destination，后面可能又其他的路可以到达destination，mark as true，visite过了
        visited[x][y]= true;
        //正常bfs步骤
        for(int i = 0; i < 4; i++){
            int nx = x;
            int ny = y;
            while(nx >= 0 && ny >= 0 && nx < row && ny < col && maze[nx][ny] == 0){
                nx += mx[i];
                ny += my[i];
            }
            // point进到墙里，要退出来
            nx -= mx[i];
            ny -= my[i];

            // 任何一个走的通,就return true,事实上，如果能return true的话，就已经找到destination了
            if(dfs(maze, new int[]{nx, ny}, destination, visited, row, col)){
                return true;
            }
        }
        //没有一条路走通的，就直接返回false
        return false;
    }

}
