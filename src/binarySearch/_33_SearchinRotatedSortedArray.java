package binarySearch;

import javax.swing.event.MenuKeyEvent;
import java.lang.annotation.Target;

/**
 * @author Diyang Li
 * @create 2022-06-12 5:50 PM
 */
public class _33_SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        int midNum;

        while(start<=end) {
            mid = start + (end - start)/2;
            midNum = nums[mid];
            if (target == midNum){
                return mid;
            }
            // mid on the first ascending part
            if (nums[start] <= midNum){
                if (target < midNum && target >= nums[start]){
                    end = mid-1;
                }else{
                    // target> midNum
                    start = mid+1;
                }
            }
            // mid on the second asceding part
            if (midNum <= nums[end]){
                if (target > midNum && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2= 3;
        int[] nums3 = {1};
        int target3 = 0;
        int[] nums4 = {3,5,1};
        int target4 = 3;

        System.out.println(search(nums1, target1));
    }
}
