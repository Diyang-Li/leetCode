package prefixSum;

/**
 * @author Diyang Li
 * @create 2022-09-06 7:58 PM
 */
public class _370_RangeAddition {
    /**
     * 差分数组
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int i = 0; i < updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            arr[start] += inc;
            if(end < length-1) arr[end+1] -= inc;
        }
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += arr[i];
            arr[i] = sum;
        }

        return arr;
    }
}
