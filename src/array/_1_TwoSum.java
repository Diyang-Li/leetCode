package array;

import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-06-21 9:21 AM
 */
public class _1_TwoSum {
    /**
     * Bruce force: O(n2), bad idea
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Use map the record the position of each element number,
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        //loop the nums and put the num:position in the map
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }

            map.put(nums[i], i);
        }
        return result;
    }

}
