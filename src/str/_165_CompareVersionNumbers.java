package str;

import java.security.cert.TrustAnchor;
import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-07-11 9:29 AM
 */
public class _165_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        // 1. use regular expression to split version 1 and 2 with given expression
        String[] stri = version1.split("\\.");
        String[] strj = version2.split("\\.");
        // 2. traverse both array, parse the string to integer [1,0] [1,0,1] -->
        //if the pointer exceed the length of array, make the position = 0;
        for(int i = 0; i < Math.max(stri.length, strj.length); i++){
            // parse the string to integer
            int inti = i < stri.length?Integer.parseInt(stri[i]) : 0;
            int intj = i < strj.length?Integer.parseInt(strj[i]) : 0;
            if(inti > intj) {
                return 1;
            }else if(inti < intj){
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        String version3 = "1.0.1";
        String version4 = "1";

        System.out.println(compareVersion(version3, version4));
    }
}
