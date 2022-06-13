package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-12 6:50 PM
 */
public class _81_SearchinRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length -1;
        int mid;
        int midNum;

        while(start <= end){
            mid = start + (end - start)/2;
            midNum = nums[mid];
            if(midNum == target){
                return true;
            }

            if(midNum > nums[start]){
                if(midNum>target && target >= nums[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(midNum < nums[start]){
                if(midNum < target&& target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid - 1;
                }
            } else{
                // midNum = nums[start]
                // for example: {1,0,1,1,1}
                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,6,0,0,1,2};
        int target1 = 0;
        int[] nums2 = {2,5,6,0,0,1,2};
        int target2 = 3;
        int[] nums3 = {1,0,1,1,1};
        int target3 = 0;
        int[] nums4 = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int target4 = 13;
        System.out.println(search(nums4, target4));
    }
}
