package sort;

/**
 * @author Diyang Li
 * @create 2022-09-03 11:29 AM
 */
public class _215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        helper(nums, 0, len-1, len-k);
        return nums[len-k];
    }

    public void helper(int[] nums, int left, int right, int target){
        if(left >= right) return;
        int wall = quickSort(nums, left, right);
        if(wall == target) return;
        else if(wall > target){
            helper(nums, left, wall-1,target);
        }else{
            helper(nums, wall+1,right, target);
        }

    }

    public int quickSort(int[] nums, int left, int right){
        int pivot = nums[right];
        int w = left;
        for(int i = left; i < right ; i++){
            if(nums[i] < pivot){
                swap(nums, w, i);
                w++;
            }
        }

        swap(nums, w, right);
        return w;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
