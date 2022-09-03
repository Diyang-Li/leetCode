package sort;

import java.util.Random;

/**
 * @author Diyang Li
 * @create 2022-09-02 4:59 PM
 */
public class _912_SortanArray {
    // use quick sort
    // O(nlogn) ~ O(n^2)
    public int[] sortArray(int[] nums) {
        helper(nums, 0, nums.length-1);
        return nums;
    }

    public void helper(int[] nums, int left, int right){
        if(left >= right) return;
        int wall = randomPartition(nums, left, right);
        helper(nums, left, wall-1);
        helper(nums, wall+1, right);
    }

    public int randomPartition(int[] nums, int l, int r){
        int i = new Random().nextInt(r-l+1)+l;
        swap(nums, r, i);
        return quickSort(nums, l, r);
    }

    public int quickSort(int[] nums, int left, int right){
        int pivot = nums[right];
        int p = left;
        int w = left; // all numbers on the left of the wall is < pivot, w and right >= pivot
        while(p < right){
            if(nums[p] < pivot){
                swap(nums, w, p);
                w++;
            }
            p++;
        }
        swap(nums, w, right);
        return w;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        _912_SortanArray sortanArray = new _912_SortanArray();
        sortanArray.sortArray(nums);
    }
}
