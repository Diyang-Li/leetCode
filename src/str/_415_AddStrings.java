package str;

import java.security.DrbgParameters;

/**
 * @author Diyang Li
 * @create 2022-07-11 11:41 AM
 */
public class _415_AddStrings {
    public static String addStrings(String num1, String num2) {
        int sum = 0;
        String rest = "";

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) {
                sum += num1.charAt(p1) - '0';
                p1--;
            }

            if (p2 >= 0) {
                sum += num2.charAt(p2) - '0';
                p2--;
            }

            rest = sum % 10 + rest;
            sum /= 10;
        }

        if (sum > 0) {
            rest = 1 + rest;
        }

        return rest;
    }

    /**
     * another way
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings1(String num1, String num2) {
        String rest = "";
        int carry = 0;
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;

        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            int v1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int v2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;

            carry += v1 + v2;
            rest = carry % 10 + rest;
            carry /= 10;
            i1--;
            i2--;
        }

        return rest;
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        addStrings1(num1, num2);
    }
}
