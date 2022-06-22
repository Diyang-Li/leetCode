package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-22 11:01 AM
 */
public class _18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // be careful that j > i+1, if j > 0 means sometime nums[i]!=nums[j]
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    // the range of int is: -128~127 --> -2147483648 ~ 2147483647
                    long sum = (long)nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        int[] nums3 = {-2, -1, -1, 1, 1, 2, 2};
        int[] nums4 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target1 = 0;
        int target2 = 8;
        int target3 = -294967296;
        System.out.println(fourSum(nums4, target3));
        long sum = (long) 1000000000+1000000000+1000000000+1000000000;
        System.out.println(sum);
    }
}
