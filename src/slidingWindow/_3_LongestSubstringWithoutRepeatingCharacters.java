package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Diyang Li
 * @create 2022-07-17 11:33 AM
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    /**
     * A more general way,
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        //1. left, right -> fist and last char of substring; rest -> reult
        int left = 0;
        int right = 0;
        int rest = 0;
        // 2. hashset -> unique char
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            while(!set.add(c)){
                set.remove(s.charAt(left));
                left++;
            }
            rest = Math.max(right - left + 1, rest);
            right++;
        }

        // 4. return rest
        return rest;
    }

    /**
     * the left could jump to the right place one time by using the map to record the position
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        //1. left, right -> fist and last char of substring; rest -> reult
        int left = 0;
        int right = 0;
        int rest = 0;
        // 2. hashmap -> unique char and the position
        HashMap<Character, Integer> map = new HashMap<>();
        // 3. while loop(right to the last char of s)
        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left) left = (map.get(c)) + 1;
            map.put(c, right);
            rest = Math.max(right - left + 1, rest);
            right++;
        }

        // 4. return rest
        return rest;
    }

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
