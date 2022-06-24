package array;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-06-24 5:34 PM
 */
public class _27_RemoveElement {
    /**
     * left has to move forward!
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] == val){
                continue;
            }else{
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }
}
