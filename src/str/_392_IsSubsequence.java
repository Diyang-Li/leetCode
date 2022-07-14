package str;

/**
 * @author Diyang Li
 * @create 2022-07-14 11:59 AM
 */
public class _392_IsSubsequence {
    /**
     * my method: O(n) O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        //1. p1 -> s  p2 -> t flag = s.length()
        int p1 = 0;
        int p2 = 0;

        //2. traverse the t, move p1 and p2 in this process
        while (p2 < t.length()){
            //3. char at p2 != p1, p2 moves forwards
            // 4. char at p2 == p1, move p1 and p2 at the same time;
            if(p1 < s.length() && s.charAt(p1) == t.charAt(p2)){
                p1++;
            }
            p2++;
        }

        return p1 == s.length();
    }
}
