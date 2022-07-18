package slidingWindow;

/**
 * @author Diyang Li
 * @create 2022-07-18 12:30 PM
 */
public class _424_LongestRepeatingCharacterReplacement {
    /**
     * O(n) O(1)
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int rest = 0;
        // or we could use map
        int[] count = new int[26];// frequency of each char in the window

        while(right < s.length()){
            char rc = s.charAt(right);
            count[rc-'A']++;

            //change operation time: length of the window - max value in the map
            while((right - left + 1) - findMax(count) > k){
                char lc = s.charAt(left);
                count[lc-'A']--;
                left++;
            }

            rest = Math.max(right - left + 1, rest);
            right++;
        }

        return rest;
    }

    public int findMax(int[] count){
        int max = 0;
        for(int i: count){
            max = Math.max(i, max);
        }
        return max;
    }
    public int characterReplacement1(String s, int k) {
        int left = 0;
        int right = 0;
        int rest = 0;
        int[] count = new int[26];// frequency of each char in the window
        int max = 0; // we could use the method for this problem because the test case is not strong
        // because the max should be updated in the shrinking process, but the max if fixed in this solution


        while(right < s.length()){
            char rc = s.charAt(right);
            count[rc-'A']++;
            max = Math.max(max, count[rc - 'A']);

            //change operation time: length of the window - max value in the map
            while((right - left + 1) - max > k){
                char lc = s.charAt(left);
                count[lc-'A']--;
                left++;
            }

            rest = Math.max(right - left + 1, rest);
            right++;
        }

        return rest;
    }
}
