import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-05-30 11:05 AM
 */
public class ReverseWordsInStringIII {
    /**
     * my method
     * @param s
     * @return
     */
    /* public static String reverseWords(String s) {
         String[] str = s.split("");
         int slow = 0;
         int fast = 0;
         int flag = 0;
         while(fast < str.length){
             if (fast+1 == str.length||str[fast+1].equals(" ")){
                 int length = fast-slow;
                 int mid = slow + (length)/2;
                 for (int i =0; i<=length/2; i++){
                     String temp = str[slow+i];
                     str[slow+i] = str[slow+length-i];
                     str[slow+length-i] = temp;
                 }
                 slow = fast + 2;
             }

             fast++;

         }
         return String.join("", str);
     }*/

    /**
     * StringBuilder
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i<str.length; i++){
            StringBuilder temp = new StringBuilder();
            temp.append(str[i]);
            sb.append(temp.reverse().append(" "));
        }
        return sb.subSequence(0, sb.length()-1).toString();
    }


    public static void main(String[] args) {
        String s = "Let's take";
        System.out.println(reverseWords(s));
    }
}
