package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Diyang Li
 * @create 2022-07-25 3:51 PM
 */
public class _219_ContainsDuplicateII {
    /**
     * use set: my method
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || k < 0){
            return false;
        }

        int left = 0;
        int right = 0;
        // 0, 1,2,3,4,5
        // [1,2,3,1,2,3]
        //          r
        //      l
        // set[3,1]
        // record the nums in the window
        Set<Integer> set = new HashSet<>();

        while(right < nums.length){
            if(right - left > k){
                set.remove(nums[left]);
                left++;
            }

            // if cannot add to set, which means duplicate, return true
            if(!set.add(nums[right])){
                return true;
            }
            right++;
        }
        return false;
    }

    /**
     * use map
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        if(nums == null ||nums.length == 0 || k < 0){
            return false;
        }

        int right = 0;
        // key: nums   value: index
        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length){
            Integer left = map.get(nums[right]);
            if(left != null && right - left <= k){
                return true;
            }

            map.put(nums[right], right);
            right++;

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        containsNearbyDuplicate1(nums, k);
    }
}
