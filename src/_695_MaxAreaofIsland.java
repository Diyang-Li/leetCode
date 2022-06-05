/**
 * @author Diyang Li
 * @create 2022-06-02 10:11 PM
 */
public class _695_MaxAreaofIsland {
    /**
     * dsf 解法
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        //一个一个点dsf，有可能一个点被dsf看过很多次，但是是不可避免的，
        //主要是避免陷入infinit loop
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dsf(grid, i, j));
            }
        }
        return ans;
    }

    public static int dsf(int[][] grid, int x, int y) {
        // basic case
        // x y 不能超过边界，
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        // 等价于733题：
        //(dirX >= 0 && dirX < rowLen && dirY >=0 && dirY < colLen&&image[dirX][dirY] == curColor)
        //能来到这里，就说明已经有一个岛面积了
        int ans = 1;

        //为了防止以后这个岛面积再被算进结果，设置为0
        grid[x][y] = 0;

        // 操控coordinate的方向
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        //上下左右进行移动
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            // 这里就是在选一个方向走，走到头，再卷回来得到结果后 ans，进入下次i++,再得到结果后累加到ans上面
            ans += dsf(grid, mx, my);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
