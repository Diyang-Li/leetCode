package divideAndConquer;

/**
 * @author Diyang Li
 * @create 2022-08-26 4:55 PM
 */
public class _215_KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        // use the quick sort
        help(nums, 0, nums.length-1, k);
        return nums[nums.length-k];
    }

    private static void help(int[] nums, int left, int right, int k){
        if(left >= right) return;

        int wall = quick(nums, left, right);
        if(wall == nums.length - k) return;
        else if(wall < nums.length - k) help(nums, wall + 1, right, k);
        else help(nums, left, wall - 1, k);
    }

    private static int quick(int[] nums, int left, int right){
        // pivot is the last item in the array
        int pivot =nums[left + (right - left)/2];
        int wall = left;
        int i = left;
        // all numbers on the left of the wall is smaller then the pivot
        // all numbers on the wall and right of the wall are >= the pivot,
        //so, after the while, exchange the position of the the pivot the nums on the wall
        // then could find the right number on the wall position, others don't need to care about.
        while(i < right){
            if(nums[i] < pivot){
                swap(nums, i, wall);
                wall++;
            }
            i++;
        }

        swap(nums, wall, right);
        return wall;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest(nums, k);
    }
}
