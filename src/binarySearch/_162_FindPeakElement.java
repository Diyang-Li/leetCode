package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-13 12:13 PM
 */
public class _162_FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = left + (right - left)/2;
            //left part
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                //right part
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,1,3,5,6,4};
        int[] nums3 = {1,3,2};
        System.out.println(findPeakElement(nums3));
    }
}
