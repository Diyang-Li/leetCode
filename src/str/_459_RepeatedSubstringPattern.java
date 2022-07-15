package str;

/**
 * @author Diyang Li
 * @create 2022-07-15 11:47 AM
 */
public class _459_RepeatedSubstringPattern {
    /**
     * my method O(n * n/2) O(n/2) i
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return false;
        int[] arr = new int[len/2+1];
        //1.find all number in [1, length/2] that could be len%num == 0
        for(int i = 1; i <= len/2; i++){
            if(len%i == 0){
                arr[i] = i;
            }
        }
        //2. traverse the arr, if the num is not 0, means substring(0, i) coule be the substring
        //4. the k should from right to left, because the larger the substing, the repeat time is smaller, which is helper to save time.
        // 3. repeat time is length/i
        for(int k = arr.length-1; k>=0; k--){
            int i = arr[k];
            if(i != 0){
                String str = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < len/i; j++){
                    sb.append(str);
                }
                String rptString = new String(sb);
                if(rptString.equals(s)) return true;
            }
        }

        return false;
    }

    /**
     * or we could use this way, O(n^2) slower then my method;
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern1(String s) {
        int len = s.length();
        if(len == 0 || len == 1) return false;
        int[] arr = new int[len/2+1];
        //1.find all number in [1, length/2], start from length/2
        //2. repeat time is length/i
        for(int i = len/2; i >= 1; i--){
            if(len % i == 0){
                int repeat = len/i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < repeat; j++){
                    sb.append(substring);
                }

                if(sb.toString().equals(s)) return true;
            }
        }

        return false;
    }

}
