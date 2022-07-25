package slidingWindow;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-07-25 9:47 AM
 */
public class _187_RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        int right = 0;
        while(right < s.length() - 9){
            String temp = s.substring(right, right+10);
            if (!seen.add(temp)){
                repeated.add(temp);
            }
            right++;
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
       String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
