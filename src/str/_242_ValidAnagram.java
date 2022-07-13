package str;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-07-13 11:46 AM
 */
public class _242_ValidAnagram {
    /**
     * use arrays tool
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        for(int i = 0; i < cs.length; i++){
            if(cs[i] != ct[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * use count[26] to count the frequency of each letter,
     * the word: 3a1g1m1n1r
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        String[] arr1= {s, t};
        String[] arr2 = new String[2];
        int len = s.length();

        for(int j = 0; j < 2; j++){
            String str = arr1[j];
            String word = "";
            int[] count = new int[26];
            for(int i = 0; i < len; i++){
                count[str.charAt(i)-'a']++;
            }

            for(int i = 0; i < 26; i++){
                if(count[i] != 0){
                    word += count[i] + String.valueOf((char)(i+'a'));
                }
            }
            arr2[j] = word;
        }

        return arr2[0].equals(arr2[1]);
    }
}
