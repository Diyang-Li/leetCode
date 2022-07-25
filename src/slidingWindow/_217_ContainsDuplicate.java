package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-25 4:02 PM
 */
public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        // key: nums  value: frequency
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) >= 1){
                return true;
            }

            map.put(nums[i], 1);
        }

        return false;
    }
}
