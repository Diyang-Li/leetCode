package slidingWindow;

/**
 * @author Diyang Li
 * @create 2022-07-21 7:37 PM
 */
public class _661_ImageSmoother {
    /**
     * Brute force, not good enough
     * Can use Trie to solve
     */
    private int[] mx = {1,-1,0, 0, -1, 1, 1, -1};
    private int[] my = {0, 0,1,-1, -1, -1, 1, 1};
    public int[][] imageSmoother(int[][] img) {
        int xlen = img.length;
        int ylen = img[0].length;
        int[][] rest = new int[xlen][ylen];

        for(int x = 0; x < xlen; x++){
            for(int y = 0;y < ylen; y++){
                int sum= 0;
                int count = 1;
                sum += img[x][y];
                for(int k = 0; k < 8; k++){
                    int nx = x + mx[k];
                    int ny = y + my[k];
                    if(nx >= 0 && nx < xlen && ny >= 0 && ny < ylen){
                        sum += img[nx][ny];
                        count++;
                    }
                }
                rest[x][y] = sum/count;
            }
        }
        return rest;
    }
}
