package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-06-22 12:49 PM
 */
public class _16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0]+nums[1]+ nums[nums.length-1];
        Arrays.sort(nums);

        for (int i = 0; i<nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum < target){
                    left++;
                }else if (curSum > target){
                    right--;
                }else {
                    return curSum;
                }
                if (Math.abs(target -curSum) < Math.abs(target - sum)){
                    sum = curSum;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int[] nums2 = {0, 0, 0};
        int[] nums3 = {0, 2, 1, -3};
        int target1 = 1;
        int target2 = 1;
        int target3 = 1;

        System.out.println(threeSumClosest(nums3, target3));

    }
}
