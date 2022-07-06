package str;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-07-06 9:58 AM
 */
public class _12_IntegertoRoman {
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M","CM", "D", "CD","C", "XC","L","XL","X","IX","V","IV","I"};


        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < values.length; i++){
            while(num >= values[i]){
                sb.append(strs[i]);
                num -= values[i];
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}

