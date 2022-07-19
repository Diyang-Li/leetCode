package str;

/**
 * @author Diyang Li
 * @create 2022-07-13 5:13 PM
 */
public class _28_ImplementstrStr {
    /**
     * my method
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        //1. p1 and p2 point to the needle length substring
        int p1 = 0;
        int p2 = 0;

        while(p2 < needle.length()-1){
            p2++;
        }

        //2. traverse the haystack
        while(p2 <= haystack.length()-1){
            String sub = haystack.substring(p1, p2+1);
            if(sub.equals(needle)){
                return p1;
            }
            p1++;
            p2++;
        }

        return -1;
    }
}
