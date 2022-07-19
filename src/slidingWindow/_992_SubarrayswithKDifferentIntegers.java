package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-19 10:03 AM
 */
public class _992_SubarrayswithKDifferentIntegers {
    /**
     * don't understand
     * @param nums
     * @param k
     * @return
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums,  k-1);
    }

    public int atMost(int[] nums, int k){
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int rest = 0;
        while(right < nums.length){
            int r = nums[right];
            if(map.getOrDefault(r, 0) == 0) k--;
            map.put(r, map.getOrDefault(r, 0)+1);

            // distinct num > k, so shink the window
            while(k < 0){
                int l = nums[left];
                map.put(l, map.get(l)-1);
                if(map.get(l) == 0) k++;
                left++;
            }

            rest += right - left + 1;
            right++;
        }

        return rest;
    }
}
