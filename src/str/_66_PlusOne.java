package str;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-07-10 6:41 PM
 */
public class _66_PlusOne {
    /**
     * brute force:
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int sum = 1;
        //1.traverse the int[] from right to left,
        for(int i = digits.length-1; i >=0; i--){
            // plus 1 to the most left digts, if >= 10, the former digit +1...
            sum += digits[i];
            digits[i] = sum % 10;
            sum /= 10;
        }

        // 2. most left digit + 1 >= 10, create a new array to put all digits
        if(sum > 0){
            int[] rest = new int[digits.length + 1];
            rest[0] = 1;
            for(int i = 1; i < rest.length; i++){
                rest[i] = digits[i-1];
            }

            digits = rest;
        }

        return digits;
    }

    /**
     * perfect method
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits){
        if (digits == null || digits.length == 0){
            return digits;
        }

        for (int i = digits.length-1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;

    }

    public static void main(String[] args) {
        int[] num1 = {9};
        System.out.println(Arrays.toString(plusOne1(num1)));
    }
}
