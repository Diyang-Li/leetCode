package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-17 10:56 PM
 */
public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        if(k == 0 || s.length() == 0){
            return 0;
        }
        int rest = 0; // record longest substring
        // use unique to limit the unique char nums in the window
        // ababbc  k=2
        for(int unique = 1; unique <= 26; unique++){
            int left = 0;
            int right  = 0;
            Map<Character, Integer> map = new HashMap<>();
            int validCount = 0;// record the number of keys in map that the frequency >= k
            // unique = 1;
            while(right < s.length()){
                char rc = s.charAt(right);
                map.put(rc,map.getOrDefault(rc, 0) + 1);
                if(map.get(rc) == k) validCount++;

                // if there is enough unique char in the window, then shink the window
                while(map.keySet().size() > unique){
                    char lc = s.charAt(left);
                    if(map.get(lc) == k) validCount--;
                    map.put(lc, map.get(lc) - 1);
                    if(map.get(lc) == 0) map.remove(lc);
                    left++;
                }

                // when come to here: the unique num of key <= unique;
                int count = map.keySet().size(); // the number of unique char in the window
                if(unique == count && count == validCount) rest = Math.max(right - left + 1, rest);

                right++;
            }
        }

        return rest;
    }

    public static void main(String[] args) {
        String s1 = "ababbc";
        int k1 = 2;
        longestSubstring(s1, k1);
    }
}
