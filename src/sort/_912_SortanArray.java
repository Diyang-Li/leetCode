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
        helper(nums, 0, nums.length - 1);
        return nums;
    }

    public void helper(int[] nums, int left, int right) {
        if (left >= right) return;
        int wall = randomPartition(nums, left, right);
        helper(nums, left, wall - 1);
        helper(nums, wall + 1, right);
    }

    public int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return quickSort(nums, l, r);
    }

    public int quickSort(int[] nums, int left, int right) {
        int pivot = nums[right];
        int p = left;
        int w = left; // all numbers on the left of the wall is < pivot, w and right >= pivot
        while (p < right) {
            if (nums[p] < pivot) {
                swap(nums, w, p);
                w++;
            }
            p++;
        }
        swap(nums, w, right);
        return w;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // merge sort
    public int[] sortArray1(int[] nums) {
        return helper1(nums, 0, nums.length - 1);
    }

    public int[] helper1(int[] nums, int left, int right) {
        if (left >= right) return new int[]{nums[left]};
        int mid = left + (right - left) / 2;
        int[] leftRes = helper1(nums, left, mid);
        int[] rightRes = helper1(nums, mid + 1, right);
        return merge(leftRes, rightRes);
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int pl = 0;
        int pr = 0;
        int p = 0;

        while (pl < left.length && pr < right.length) {
            if (left[pl] < right[pr]) {
                res[p] = left[pl];
                pl++;
            } else {
                res[p] = right[pr];
                pr++;
            }

            p++;
        }


        while (pl < left.length) {
            res[p] = left[pl];
            p++;
            pl++;
        }


        while (pr < right.length) {
            res[p] = right[pr];
            p++;
            pr++;
        }

        return res;
    }
}
