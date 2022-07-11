package str;

/**
 * @author Diyang Li
 * @create 2022-07-11 3:16 PM
 */
public class _344_ReverseString {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        //1. p1 -> first
        //2. p2 -> last
        int p1 = 0;
        int p2 = s.length-1;

        //3. move together
        while(p1 < p2){
            swap(s, p1, p2);
            p1++;
            p2--;
        }
    }

    public void swap(char[] s, int a, int b){
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}
