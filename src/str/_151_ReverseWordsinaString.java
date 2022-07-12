package str;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-07-12 9:10 AM
 */
public class _151_ReverseWordsinaString {

    /**
     * using stack
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //1.trim the s
        int left = 0;
        int right = s.length() -1;

        while(left < right && s.charAt(left) == ' ') left ++;
        while(left < right && s.charAt(right) == ' ') right--;

        //2. from left to right to put the word into a queue
        Stack<String> d = new Stack<>();

        StringBuilder word = new StringBuilder();

        while(left<=right){
            char c = s.charAt(left);
            // if len of sb is not 0: sb has letters, can be a word
            //  c == ' ': there is no whitespace in the word
            //  push the sb(to string) to queue
            int len = word.length();
            if ((word.length() != 0) && (c == ' ')){
                d.add(word.toString());
                // set sb to 0
                word.setLength(0);
            }else if(c!=' '){
                // c!=' ' means the left pointer still not come to the end of the word
                word.append(c);
            }
            left++;
        }
        //don't forget the last word!!
        d.add(word.toString());
        String rest = "";
        while (!d.isEmpty()){
            rest+= " " + d.pop();
        }
        return rest.trim();
    }

    public static String reverseWords1(String s) {
        String[] array = s.split("//s+");
        return null;
    }



    public static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords1(s));
    }
}
