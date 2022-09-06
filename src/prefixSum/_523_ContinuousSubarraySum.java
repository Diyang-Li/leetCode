package prefixSum;

import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-09-06 12:45 PM
 */
public class _523_ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //     mod      position
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int mod = sum%k;
            if(map.containsKey(mod)) {
                if(Math.abs(i + 1 - map.get(mod)) >= 2){
                    return true;
                }
            }else{
                map.put(mod, i+1);
            }

        }

        return false;
    }
}
