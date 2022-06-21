package array; /**
 * @author Diyang Li
 * @create 2022-05-28 2:06 PM
 */

import javax.swing.plaf.nimbus.State;
import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 */
public class _167_TwoSumIIInputArrayIsSorted {
    /**
     * 其中一种做法，start = 0 end = 最后，相加，数大了end往前， 数小了往后
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
            int start = 0;
            int end = numbers.length-1;
            int[] result = new int[2];

            while(start<end){
                int num1 = numbers[start];
                int num2 = numbers[end];
                if(num1 + num2 > target){
                    end --;
                }else if(num1 + num2 < target){
                    start++;
                }else{
                    result[0] = start+1;
                    result[1] = end +1;
                    break;
                }
            }

            return result;
        }


    public static void main(String[] args) {
        int[] nums = {-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
