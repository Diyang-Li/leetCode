package slidingWindow;

/**
 * @author Diyang Li
 * @create 2022-07-23 9:56 AM
 */
public class _567_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        // s1: short
        // s2: long

        int left = 0;
        int right = 0;
        int count = s1.length();
        int[] chars = new int[26];

        for(char c: s1.toCharArray()){
            chars[c - 'a']++;
        }

        while(right < s2.length()){
            char rc = s2.charAt(right);
            chars[rc-'a']--;
            // if the rc >= 0 in chars, means it's a valid count, neet to change tha value of count
            if(chars[rc-'a'] >= 0){
                count--;
            }
            // if the lc in chars <= 0, means it's not a valid char, don't change the count
            if(right - left + 1 > s1.length()){
                char lc = s2.charAt(left);
                chars[lc - 'a']++;
                if(chars[lc - 'a'] > 0){
                    count++;
                }
                left++;
            }

            if(count == 0){
                return true;
            }
            right++;
        }
        return false;
    }
}
