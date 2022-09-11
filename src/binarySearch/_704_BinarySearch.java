package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-09-11 12:51 PM
 */
public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        int res = -1;
        int left = -1;
        int right = nums.length;

        while(left+1!=right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                res = mid;
                break;
            }
        }

        return res;
    }
}
