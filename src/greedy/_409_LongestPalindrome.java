package greedy;

/**
 * @author Diyang Li
 * @create 2022-10-09 12:44 PM
 */
public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }

        int res = 0;
        for(int c: count){
            res += c/2*2;
            if(res%2 == 0 && c%2 ==1){
                res++;
            }
        }

        return res;
    }
}
