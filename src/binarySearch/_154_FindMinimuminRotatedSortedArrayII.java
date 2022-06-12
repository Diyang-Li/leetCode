package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-12 10:47 AM
 */
public class _154_FindMinimuminRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        int midNum;

        while(start <= end){
            mid = start + (end - start)/2;
            midNum = nums[mid];
            if (midNum < nums[end]){
                end = mid;
            }else if (midNum > nums[end]){
                start = mid +1;
            }else {
                end--;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,2,2,0,1};
        int[] nums3 = {4,5,6,7,0,1,4};
        int[] nums4 = {1,3,3};
        System.out.println(findMin(nums2));
    }
}
