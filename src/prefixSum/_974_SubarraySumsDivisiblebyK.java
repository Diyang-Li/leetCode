package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-09-06 11:43 AM
 */
public class _974_SubarraySumsDivisiblebyK {
    //(preSum1 - preSum2)/k = n(mod) -->preSum1 -preSum2 = n*k --> thre must be n ks between preSum1 and preSum2（同余定理）
    // preSum[j]modk = preSum[j-i]modk sum(i, j)%k = 0(Modular arithmetic)
    // these ks can be divisible by k
    public int subarraysDivByK(int[] nums, int k) {
        // mod      frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;

        for(int  i = 0; i < nums.length; i++){
            sum += nums[i];
            int mod = (sum%k+k)%k;//如果是负数取正余
            int freq = map.getOrDefault(mod, 0);
            res+=freq;
            map.put(mod, freq+1);
        }

        return res;
    }
}
