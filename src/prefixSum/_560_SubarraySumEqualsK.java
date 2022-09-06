package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-09-05 11:15 PM
 */
public class _560_SubarraySumEqualsK {
    /**
     * use HashMap to record the presum
     * @param nums
     * @param k
     * @return
     */
    //preSum1 - k = preSum2 --> preSum1 - preSum2 = k
    public int subarraySum1(int[] nums, int k) {
        // presum   frequency:记录前面preSum2的频率
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// num = k时可用

        int res = 0;
        int preSum1 = 0;
        for(int i = 0; i < nums.length; i++){
            preSum1 += nums[i];
            int preSum2 = preSum1 - k;
            if(map.containsKey(preSum2)) res+=map.get(preSum2);
            map.put(preSum1, map.getOrDefault(preSum1, 0) + 1);
        }

        return res;

    }
    // prefix sum: O(n^2)
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int[] sums = new int[nums.length+1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        for(int i = 0; i < sums.length; i++){
            for(int j = i+1; j < sums.length;j++){
                if(sums[j] - sums[i] == k){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(-1%5);
    }
}
