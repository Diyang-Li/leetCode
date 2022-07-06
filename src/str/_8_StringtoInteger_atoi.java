package str;

/**
 * @author Diyang Li
 * @create 2022-07-06 3:33 PM
 */
public class _8_StringtoInteger_atoi {
    public static int myAtoi(String s) {
        // s = "-12 good"
        if(s == null || s.length() == 0){
            return 0;
        }

        //ignore whitespace
        s = s.trim();

        if(s.length() == 0) return 0;
        int sign = 1;
        char firstChar = s.charAt(0);
        int cur = 0; //
        long rest = 0;

        //check sign, to determain the negative or positive
        if(firstChar == '+'){
            sign = 1;
            cur++;
        }else if(firstChar == '-'){
            sign = -1;
            cur++;
        }

        // traverse the s
        for(int i = cur; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return (int)rest * sign;
            }

            rest = rest*10 + s.charAt(i) - '0';

            if(sign == 1 && rest > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && rest > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }

        return (int) rest * sign;
    }

    public static void main(String[] args) {
        String s = s = "   -42";
        System.out.println(myAtoi(s));
    }
}
