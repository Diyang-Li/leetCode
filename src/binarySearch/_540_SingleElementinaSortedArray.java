package binarySearch;

/**
 * @author Diyang Li
 * @create 2022-06-13 9:51 AM
 */
public class _540_SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end -start)/2;
            if(mid%2 == 0){
                if(nums[mid] == nums[mid-1]){
                    end = mid-2;
                }else if(nums[mid] == nums[mid+1]){
                    start = mid+2;
                }else{
                    return nums[mid];
                }
            }else{
                if(nums[mid] == nums[mid-1]){
                    start = mid+1;
                }else if(nums[mid] == nums[mid+1]){
                    end = mid -1;
                }else{
                    return mid;
                }
            }

        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums1 = {3,3,7,7,10,11,11};
        int[] nums2 = {1,1,2};
        System.out.println(singleNonDuplicate(nums2));
    }
}
