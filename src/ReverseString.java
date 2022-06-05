import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-05-30 10:19 AM
 */

/**
 * 这个问题错了，原因为：长度为奇数的时候， mid在中间点前一个，然而，偶数的时候，中间点在后一个
 * 遇到找中点的问题的时候，binary search除外，有固定模板，要仔细考虑这个问题
 */
public class ReverseString {
    public static void reverseString(String[] s) {
        if(s == null || s.length == 0){
            return;
        }
        int mid = (s.length-1)/2;
        for (int i = 0; i<=mid; i++){
            String temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }

    }

    public static void main(String[] args) {
        String[] input = {"n",","," ","a"," ","c"};
        //{c}
        System.out.println(Arrays.toString(input));
        reverseString(input);
        System.out.println(Arrays.toString(input));
        String[] excepted = {"c"," ","a"," ",",","n"};
        System.out.println(Arrays.toString(excepted));
    }
}
