import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-06-02 10:09 AM
 */
public class _733_FloodFill {
    private static int[] dx = {1,0,0,-1};
    private static int[] dy = {0, 1,-1,0};

    /**
     * bsf 的解法： 用queue辅助record path，poll的int[] connect to four direction
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor){
            return image;
        }

        int rowLen = image.length;
        int colLen = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int curX = cell[0];
            int curY = cell[1];

            for(int i = 0; i < 4; i++){
                int dirX = curX+ dx[i];
                int dirY = curY + dy[i];

                if(dirX >= 0 && dirX < rowLen && dirY >=0 && dirY < colLen&&image[dirX][dirY] == curColor){
                    queue.offer(new int[]{dirX, dirY});
                    image[dirX][dirY] = newColor;
                }
            }
        }
        return image;

    }


    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        System.out.println(floodFill(image, sr, sc, newColor));
    }
}
