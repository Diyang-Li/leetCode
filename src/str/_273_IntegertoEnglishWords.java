package str;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * @author Diyang Li
 * @create 2022-07-07 10:05 AM
 */
public class _273_IntegertoEnglishWords {
    static String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] thousands = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }

        String rest = ""; // record the result
        int i = 0; // record the digit

        while (num != 0) {
            if (num % 1000 != 0) {
                rest = helper(num % 1000) + thousands[i] + " " + rest;
            }
            num /= 1000;
            i++;
        }
        return rest.trim();
    }

    /**
     * recursion
     * @param num
     * @return
     */

    public static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return less20[num] + " ";
        }else if (num < 100){
            return tens[num/10] + " " + helper(num % 10);
        }else {
            return less20[num/100] + " Hundred " + helper(num % 100);
        }
    }

    /**
     * not recursion
     *
     * @param num
     * @return
     */
    public static String helper1(int num) {
        String rest = "";
        if (num % 100 != 0) {
            int mod = num % 100;
            if (mod < 20) {
                rest += less20[mod];
            } else {
                rest += "" + tens[mod / 10] + " " + less20[mod % 10];
            }
        }

        if (num / 100 != 0) {
            rest = "" + less20[num / 100] + " Hundred " + rest;
        }
        return rest.trim();
    }

    public static void main(String[] args) {
        int n1 = 12345;
        System.out.println(numberToWords(n1));
    }
}
