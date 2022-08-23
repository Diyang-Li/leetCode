package bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Diyang Li
 * @create 2022-08-23 11:15 AM
 */
public class _505_TheMazeII {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // record the distance from the start
        // don't need the visited list like 490, because the point can be visited for finding out the shortest path
        // but use count + distance[cur[0]][cur[1]] < distance[x][y] can help to end the while loop in dijsktra method
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijsktra(maze, start, destination, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE? -1: distance[destination[0]][destination[1]];
    }

    // find the shortest distance to the point that can make the ball stop, if the destination is the stop point, the distance must be updated
    // or the distance will be max value
    public void dijsktra (int[][] maze, int[] start, int[] destination, int[][] distance){
        // could use Queue here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2] - b[2]));
        pq.offer(new int[]{start[0], start[1], 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            //move the ball in four directions
            for(int[] dir: dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                int count = 0;

                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                x -= dir[0];
                y -= dir[1];

                if(count + distance[cur[0]][cur[1]] < distance[x][y]){
                    distance[x][y] = count + distance[cur[0]][cur[1]];
                    pq.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
    }
}
