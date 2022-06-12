package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-11 11:00 PM
 */
public class _153_FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end =nums.length-1;

        int mid = 0;
        while(start<=end){
            mid = start + (end - start)/2;
            // the last should be always larger of equals to the mid
            // if larger, we totaly abandon mid
            // if equals, this is the target we want, since mid always be the previous of the end, when equals, the start = end
            // so just make start + 1, then start > end, stop the while, get the start -1 position
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else if (nums[mid] == nums[end]){
                end--;
            }
            else{
                // No end = mid - 1;
                // Because
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(findMin(nums));
    }
}
