package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-24 4:34 PM
 */
public class _75_SortColors {
    // use merget sort
    public static void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int left = 0;
        int right = nums.length-1;
        mergeProcess(nums, left, right);
    }

    public static void mergeProcess(int[] nums, int l, int r){
        if(l == r){
            return;
        }

        int mid = l + (r-l)/2;
        mergeProcess(nums, l, mid);
        mergeProcess(nums, mid+1, r);
        merge(nums, mid, l, r);
    }

    public static void merge(int[] nums, int mid, int l, int r){
        int[] helper = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0; //index of helper

        while(p1 <= mid && p2 <= r){
            helper[i++] = nums[p1] <= nums[p2]? nums[p1++]: nums[p2++];

        }

        while(p1 <= mid){
            helper[i++] = nums[p1++];
        }

        while (p2 <= r){
            helper[i++] = nums[p2++];
        }

        for(int j = 0; j < helper.length;j++){
            nums[j+l] = helper[j];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        int[] nums2 = {2,0,1};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
