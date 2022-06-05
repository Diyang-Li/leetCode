import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-06-05 2:17 PM
 */
public class _994_Rotting_Oranges {
    /**
     * Relationship between number of oranges and time;
     * 1. No orange in grid --> 0
     * 2. No fresh orange in grid --> 0
     * 3. All fresh orange --> -1
     * 4. Some fresh orange, but after rotting process, still have fresh orange --> -1
     * 5. Some fresh orange, but no fresh orange after rotting process --> time -1
     *
     * Why time -1?
     *   Because each time the orange rotted,it will be added into the queue, the last time of rotting process,
     *   no orange will be rotated, but time++, so we need to time-1;
     *   The condition only happens in the last time
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen =grid[0].length;
        int time = 0;
        int cnt = 0;


        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++ ){
            for (int j = 0; j < colLen; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        if (cnt == 0){
            return 0;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int j = 0; j<size; j++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i<4; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];

                    if(mx >= 0 && my >= 0 && mx < rowLen && my < colLen && grid[mx][my] == 1){
                        grid[mx][my] = 2;
                        queue.add(new int[]{mx, my});
                        cnt--;
                    }
                }

            }
            time++;
        }

        if(cnt > 0){
            return -1;
        }

        return time-1;
    }


    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
