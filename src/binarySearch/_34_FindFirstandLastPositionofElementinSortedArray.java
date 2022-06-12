package binarySearch;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Diyang Li
 * @create 2022-06-11 7:27 PM
 */
public class _34_FindFirstandLastPositionofElementinSortedArray {
    /**
     * my method, but the O(n) runtime complexity
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        int midNum = nums[0];
        while (start <= end) {
            mid = start + (end - start) / 2;
            midNum = nums[mid];
            if (midNum < target) {
                start = mid + 1;
            } else if (midNum >= target) {
                end = mid - 1;
            }
        }
        if (start >= nums.length) {
            return new int[]{-1, -1};
        }
        if (nums[start] != target) {
            return new int[]{-1, -1};
        } else {
            int[] result = new int[2];
            result[0] = start;
            while (start <= nums.length - 1) {
                if (nums[start] != target) {
                    break;
                }
                start++;
            }
            result[1] = start - 1;
            return result;
        }
    }

    /**
     * Combinet the answer and my template
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        //use one binarySearch find the first and last one number in the array
        // first = true
        // last = false;
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        if (left < nums.length && right < nums.length && nums[left]== target && nums[right] == target){
            return new int[]{left, right};
        }
        return new int[]{-1, -1};

    }

    public static int binarySearch(int[] nums, int taregt, boolean lower) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int midNum = nums[mid];
            if (midNum > taregt) {
                end = mid - 1;
            } else if (lower && midNum == taregt) {
                // if find the first one, maybe there is another target on the left
                // so move the end to left
                // if not find, star and end will stop at the last position of the left part
                // all number smaller than the target
                // so, then in the next while, the start will move to right, come back to the first target num,
                // return start in the answer
                end = mid - 1;
            } else {
                // lower == false && midNum <=target;
                // find the last target in the array
                // if we come to the target, maybe there is target on the right;
                start = mid + 1;
            }
        }
        if (lower) {
            return start;
        }else {
            return end;
        }

    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange1(nums, target)));
    }
}
