package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-05-28 12:22 PM
 */
public class _283_MoveZeroes {
    /*public static void moveZeroes(int[] nums) {
        int[] tempZero = new int[nums.length];
        int zeroPos = nums.length-1;
        int nonZeroPos = 0;
        for(int i= 0; i<nums.length; i++){
            if (nums[i] == 0){
                zeroPos--;
            }else{
                nums[nonZeroPos] = nums[i];
                nonZeroPos++;
            }
        }

        for (int i = zeroPos+1; i<nums.length; i++){
            nums[i] = tempZero[i];
        }

    }
*/

    /**
     * 不需要创建额外空间，时间复杂度O（n）
     * @param nums
     */
    public static void moveZeroes(int[] nums){
        int zeroPos = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != 0){
                swap(nums, zeroPos, i);
                zeroPos++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
