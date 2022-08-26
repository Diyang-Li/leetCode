package divideAndConquer;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-08-25 5:07 PM
 */
public class _169_MajorityElement {
    /**
     * Divide and Conquer
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return conquer(nums, 0, nums.length-1);
    }

    private int conquer(int[] nums, int left, int right){
        if(left == right) return nums[left];

        int mid = left + (right - left)/2;
        int leftRes = conquer(nums, left, mid);
        int rightRes = conquer(nums, mid+1, right);

        if(leftRes == rightRes) return leftRes;
        else{
            int leftCount = count(leftRes, nums, left, right);
            int rightCount = count(rightRes, nums, left, right);

            return leftCount > rightCount? leftRes: rightRes;
        }
    }

    private int count(int target, int[] nums, int left, int right){
        int c = 0;
        for(int i = left; i <= right; i++){
            if(nums[i] == target) c++;
        }

        return c;
    }

    /**
     * By using sort
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * candidate and count
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int i: nums){
            if(count == 0) candidate = i;
            count += (candidate == i)? 1:-1;
        }

        return candidate;
    }
}
