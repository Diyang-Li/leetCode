/**
 * @author Diyang Li
 * @create 2022-06-09 11:24 PM
 */
public class _35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        while(start<=end){
            mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid -1;
            }else if(nums[mid]<target){
                start = mid +1;
            }else{
                //If find the target in the nums, just return the index
                return mid;
            }
        }
        if(nums[mid] > target){

            return mid;
        }else{
            return mid+1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
