package str;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

/**
 * @author Diyang Li
 * @create 2022-07-11 3:41 PM
 */
public class _345_ReverseVowelsofaString {
    /**
     * my method
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        String vow = "aeiouAEIOU";

        //1. p1 -> first; p2 -> last
        int p1 = 0;
        int p2 = s.length()-1;
        //move forward

        char[] c = s.toCharArray();

        boolean lflag = false;
        boolean rflag = false;

        int left = 0;
        int right = 0;

        while(p1 < p2){
            if(vow.indexOf(c[p1])!= -1){
                lflag = true;
                left = p1;
            }else{
                p1++;
            }

            if(vow.indexOf(c[p2])!= -1){
                rflag = true;
                right = p2;
            }else{
                p2--;
            }

            if(lflag && rflag){
                swap(c, left, right);
                p1++;
                p2--;
                lflag = false;
                rflag = false;
            }
        }

        return new String(c);

    }

    /**
     * a better one
     * @param s
     * @return
     */

    public String reverseVowels1(String s) {
        // left righ pointer
        int left = 0;
        int right = s.length()-1;
        String vowels = "aeiouAEIOU";

        char[] c = s.toCharArray();

        // move two pointers to oppsite direction
        while(left < right){
            // move left until find vowels
            // if there is no vowels in the string, left == right after the while loop
            while(left < right && vowels.indexOf(c[left])== -1){
                left++;
            }

            // move right until find vowels
            while(left < right && vowels.indexOf(c[right]) == -1){
                right--;
            }


            swap(c, left, right);
            left++;
            right--;
        }

        return new String(c);
    }



    public static void swap(char[] c, int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        String s ="leetcode";
        System.out.println(reverseVowels(s));
    }
}
