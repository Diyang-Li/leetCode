package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-23 10:58 PM
 */
public class _532_K_diffPairsinanArray {
    public static int findPairs(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        if(len < 2){
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len -1; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < len; j++){
                if(nums[j] - nums[i] == k){
                    res++;
                    // forget the break first time;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,4,1,5};
        int[] nums2 = {1,3,1,5,4};
        int[] nums3 = {1,2,4,4,3,3,0,9,2,3};
        int k1 = 2;
        int k2 = 0;
        int k3 = 3;
        System.out.println(findPairs(nums3, k3));
    }
}
