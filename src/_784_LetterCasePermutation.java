
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-07 11:31 PM
 */
public class _784_LetterCasePermutation {

    static LinkedList<Character> path = new LinkedList();
    static List<String> res = new LinkedList<>();

    /**
     * backtracking;
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        backTracking(ch, 0, n);
        return res;
    }
    private static void backTracking(char[] ch, int index, int n) {
        res.add(new String(ch));
        for (int i = index; i < n; i++) {
            if (isDigit(ch[i])) {
                continue;
            }
            ch[i] ^= 32;
            backTracking(ch, i + 1, n);
            ch[i] ^= 32;
        }
    }

    private static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        String s = "3z4";
        System.out.println(letterCasePermutation(s));
    }
}
