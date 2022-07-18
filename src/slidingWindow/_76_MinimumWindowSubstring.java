package slidingWindow;

import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-07-17 9:15 PM
 */
public class _76_MinimumWindowSubstring {
    /**
     * HARD!
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // 1. hashmap to record the frequency of each char in t
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 2. left right pinter to record the boundary of sliding window
        // 3. minStart start point of the return substring
        // 4. count: the number of char in string that could be included in the sliding window
        // 5. minLen: the length of current valid substring
        int left = 0, right  = 0, minStart = 0, count = 0, minLen = Integer.MAX_VALUE;
        // 6. while(right comes to the last element of the string)
        while(right < s.length()){
            char c = s.charAt(right);
            //if the char at right in the map: map = {A:1, B:1, C:1}
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    count++;
                }
                map.put(c, map.get(c)-1);
            }
            //if count == t.length()
            while(count == t.length()){
                char lc = s.charAt(left);
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    minStart = left;
                }

                if(map.containsKey(lc)){
                    // left will move to right one in the end of the current loop
                    // so we have to treat the value of lc in map and count
                    map.put(lc, map.get(lc)+1);
                    if(map.get(lc) > 0) count--;
                }

                left++;
            }

            right++;

        }

        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLen);

    }
}
