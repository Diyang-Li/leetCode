package array;

import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-06-23 10:20 AM
 */
public class _454_4SumII {
    /**
     * use hash map to record the all sum conditions and frequency O(n^2)
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for(int i: nums1){
            for(int j: nums2){
                // the result of all sum and its frequency
                map.put(i+j, map.getOrDefault(i+j, 0)+1);
            }
        }

        // find the 0-(n+m) in the map.
        for(int n: nums3){
            for(int m: nums4){
                int sum = 0 - (n+m);
                result += map.getOrDefault(sum, 0);
            }
        }

        return result;
    }
}
