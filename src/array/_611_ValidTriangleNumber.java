package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-23 10:02 PM
 */
public class _611_ValidTriangleNumber {
    /**
     *  Brute Force
     * @param nums
     * @return
     */
    // i + j > k ijk are different
    public static int triangleNumber(int[] nums) {
        int res = 0;
        if(nums.length < 3){
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] > nums[k]){
                        res++;
                    }else{
                        break;
                    }
                }
            }
        }

        return res;
    }

    /**
     * like two sum
     * @param nums
     * @return
     */

    public static int triangleNumber1(int[] nums) {
        int res = 0;
        int len = nums.length;
        if ( len < 3){
            return res;
        }

        Arrays.sort(nums);

        for(int i = len-1; i >= 2; i--){
            int j = i -1, k = 0;
            while (j > k){
                if(nums[i] < nums[j] + nums[k]){
                    res = j - k;
                    j--;
                }else{
                    k++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,3,4};
        int[] nums2 = {4,2,3,4};
        System.out.println(triangleNumber1(nums1));
    }
}
