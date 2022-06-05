import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-06-04 6:18 PM
 */
public class _542_01_Matrix {
    /**
     * timeout Time Limit Exceeded, 可能key point是要记录下曾经算过的点，但是我不会,解法应该是动态规划，等学了在做
     * @param mat
     * @return
     */
/*    public int[][] updateMatrix(int[][] mat) {
        if (mat == null){
            return null;
        }

        int rowLen = mat.length;
        int colLen = mat[0].length;

        int[][] result = new int[rowLen][colLen];

        for (int i = 0; i<rowLen; i++){
            for (int j = 0; j<colLen; j++){
                int curDis= nearest(mat, i, j);
                result[i][j] = curDis;
            }
        }

        return result;
    }

    public int nearest(int[][] mat, int x, int y){
        if(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length|| mat[x][y] == 0){
            return 0;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int dis = 1;

        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            dis+=Math.min(dis, nearest(mat, mx, my));
        }

        return dis;
    }
    public int[][] updateMatrix01(int[][] mat){
        return null;
    }*/

    /**
     * 答案做法思路：如果计算每个1到0的距离，有些计算就会被浪费，如：example2中的mat[2][1], 需要走两步才能看到0，这个cell周围1曾经计算过的nearest distance
     * 都被浪费了，所以不如转化为0到最近的1的距离，也就是说，从cell = 0处开始，distance都是0， 再找与这些0距离最近的1是哪些，标记这些1的位置为看过，
     * 还有他们再result array中的距离，接下为这些被看过的1为一个整体（做法就是加入queue中，每poll一个，就找里这个1cell最近的1是谁），
     * 再找与他们最近的1的距离，如此反复....知道queue中的cell都被弹出，整个mat都被看过，结束循环，return result array
     *
     * 做法就是：农村包围城市...这样的比喻
     * @param mat
     * @return
     */

    public int[][] updateMatrix(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;

        //创建一个每个cell=0的result，默认都是0
        int[][] result = new int[rowLen][colLen];
        // 用来判断是否被看过，默认都没看过，false
        boolean[][] path = new boolean[rowLen][colLen];
        // update过的cell加进来，未来更新周围未被update的周围的cell，
        //同时把被看过的当作一个整体，挨个去找距离最近的 1
        Queue<int[]> queue = new LinkedList<>();

        //最先把mat为0的coordinate update到result中，把path中对应的false，改成ture，形成第一个所有点为0的整体
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if (mat[i][j] == 0){
                    path[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 操纵移动的坐标
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //queue为空意味着，所有看过的cell的周围全部更新过，也就是更新完了所有的cell
        while(!queue.isEmpty()){
            // 看看哪个已经update的小可爱，周围的还没有update过呢
            int[] curCell = queue.poll();
            //当前cell的coordinate
            int x = curCell[0];
            int y = curCell[1];

            // move up dowm lef right
            for(int i = 0; i<4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];

                // Not out of bounds &&  Haven't been updated
                if(mx >= 0 && my >= 0 && mx < rowLen && my < colLen && !path[mx][my]){
                    path[mx][my] = true;
                    // Current cell' distance of nearest 0, plus 1, since [mx, my] needs to move 1 step to the current cell.
                    result[mx][my] = result[x][y] + 1;
                    // add the move cell to the queue, for find the cells around the move cells.
                    queue.add(new int[]{mx, my});
                }
            }
        }

        return result;
    }

}
