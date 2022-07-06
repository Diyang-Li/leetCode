package str;

/**
 * @author Diyang Li
 * @create 2022-07-06 9:42 AM
 */
public class _13_RomantoInteger {
    private static int v(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:break;
        }
        return 0;
    }

    /**
     * ab is pattern, if b is lager than a, then the usm of ab - 2*a
     * @param s
     * @return
     */

    public static int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            ans += v(s.charAt(i));
            if (i>=1 && v(s.charAt(i)) > v(s.charAt(i-1))){
                ans -= v(s.charAt(i-1)) * 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "MCMXCIV";
        System.out.println(romanToInt(s1));
    }
}
