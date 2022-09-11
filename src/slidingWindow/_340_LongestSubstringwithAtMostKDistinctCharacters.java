package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-09-11 10:34 AM
 */
public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // char    frequency
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left =0;
        int res = 0;

        while(right < s.length()){
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while(map.size() > k){
                char lc = s.charAt(left);
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0) map.remove(lc);
                left++;
            }

            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}
