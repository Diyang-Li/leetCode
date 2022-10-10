package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2022-10-06 9:02 PM
 */
public class _91_DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }

        int[] res = new int[s.length()+1];
        res[0] = 1; // 是为了226,pointer at the second2(n=2,p=1), 2=1 22=1+1
        // 206 pointer=0, 0=0, 20=1
        res[1] = s.charAt(0) == '0'? 0:1;

        for(int n = 2; n < res.length; n++){
            int two = Integer.parseInt(s.substring(n-2,n));
            int one = Integer.parseInt(s.substring(n-1,n));
            if(two >= 10 && two <= 26){
                res[n] += res[n-2];
            }
            if(one != 0){
                res[n] += res[n-1];
            }
        }

        return res[s.length()];
    }
}
