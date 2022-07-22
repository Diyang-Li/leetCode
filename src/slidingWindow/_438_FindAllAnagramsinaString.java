package slidingWindow;

import javax.sound.midi.Soundbank;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-22 10:18 AM
 */
public class _438_FindAllAnagramsinaString {
    /**
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int count = 0; // count the number of valid char
        List<Integer> rest = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        // frequency of char in p,also record if the frequency of a char in window has exceeded the frequency in p
        // if exceed, don't change count, because the extra char is not a valid char

        int slen = s.length();
        int plen = p.length();

        // count the frequency of char in p
        for (int i = 0; i < plen; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (map.getOrDefault(rc, 0) - 1 >= 0) count++;
            map.put(rc, map.getOrDefault(rc, 0) - 1);


            while (right - left + 1 > plen) {
                char lc = s.charAt(left);
                if (map.get(lc) >= 0) count--;
                map.put(lc, map.get(lc) + 1);
                left++;
            }

            if (count == plen && right - left + 1 == plen) {
                rest.add(left);
            }
            right++;
        }

        return rest;
    }

    /**
     * use int[] is a faster way
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return  res;
        int start = 0;
        int end = 0;
        int[] chars = new int[26];

        for (char c: p.toCharArray()){
            chars[c-'a'] ++;
        }

        int count = p.length();
        // 0 1 2 3 4 5 6 7 8 9
        // c b a e b a b a c d
        // e
        // s
        // a = 1, b= 1, c=1

        // count
        while (end < s.length()){

            // time to shrink the window
            if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >=0){
                count++;
            }
            // the char at end position -- then end++
            if(--chars[s.charAt(end++) - 'a'] >= 0){
                count--;
            }

            if (count == 0) res.add(start);
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(findAnagrams1(s1, p1));
    }

}
