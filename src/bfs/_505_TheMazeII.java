package bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Diyang Li
 * @create 2022-08-23 11:15 AM
 */
public class _505_TheMazeII {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // record the distance from the start
        // don't need the visited list like 490, because the point can be visited for finding out the shortest path
        // but use count + distance[cur[0]][cur[1]] < distance[x][y] can help to end the while loop in dijsktra method
        int row = maze.length;
        int col = maze[0].length;
        if (row == 0 && col == 0) {
            return -1;
        }
        // record the minium distance;
        int[][] dis = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[start[0]][start[1]] = 0;
        dijsktra(maze, dis, start);

        int res = dis[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // find the shortest distance to the point that can make the ball stop, if the destination is the stop point, the distance must be updated
    // or the distance will be max value
    private void dijsktra(int[][] maze, int[][] dis, int[] start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        int row = maze.length;
        int col = maze[0].length;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int count = 0;
                int x = cur[0];
                int y = cur[1];

                while (x >= 0 && y >= 0 && x < row && y < col && maze[x][y] != 1) {
                    x += dx[i];
                    y += dy[i];
                    count++;
                }

                x -= dx[i];
                y -= dy[i];
                count--;

                if (count + dis[cur[0]][cur[1]] < dis[x][y]) {
                    dis[x][y] = count + dis[cur[0]][cur[1]];
                    pq.offer(new int[]{x, y, dis[x][y]});
                }
            }
        }
    }

    public static void main(String[] args) {
       Boolean[] a  = new Boolean[2];
        System.out.println(a[1] = false);
    }
}

