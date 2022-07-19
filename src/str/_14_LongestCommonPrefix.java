package str;

/**
 * @author Diyang Li
 * @create 2022-07-14 12:38 PM
 */
public class _14_LongestCommonPrefix {
    /**
     * my method: O(n^2) O(n)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        // 1. find the smallest length in the array
        int len = 200;
        for(String str: strs){
            if(str.length() < len){
                len = str.length();
            }
        }

        int p = 0;
        StringBuilder sb = new StringBuilder();
        // 2. p - > position of char that I want to check

        while(p < len){
            // 3. traverse the first word, and check same p index of all other word in the array
            char c = strs[0].charAt(p);
            for(int i = 1; i < strs.length; i++){
                if(strs[i].charAt(p) != c) return sb.length() == 0? "": new String(sb);
            }

            sb.append(c);
            p++;
        }

        return sb.length() == 0? "": new String(sb);
    }

    public static String longestCommonPrefix1(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

        int minLen = 200;
        for(String str: strs){
            if(str.length() < minLen){
                minLen = str.length();
            }
        }

        int left = -1;
        int right = minLen;



        return strs[0].substring(0, left);
    }

    public static boolean check(String[] arr, int i){
        String str = arr[0].substring(0, i);
        for(int j = 0; j < arr.length; j++){
            if (!arr[j].startsWith(str)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
    }
}
