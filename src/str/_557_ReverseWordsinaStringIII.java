package str;

/**
 * @author Diyang Li
 * @create 2022-07-12 11:59 AM
 */
public class _557_ReverseWordsinaStringIII {
    /**
     * my method O(n) O(n)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //1. split the s by " "
        String[] array = s.split(" ");
        // 2. traverse the array and reverse each word
        for(int i = 0; i< array.length; i++){
            array[i] = reverse(array[i]);
        }

        // 3. combine the words in the array
        StringBuilder sb = new StringBuilder();
        for(String str: array){
            sb.append(str + " ");
        }

        return sb.toString().trim();
    }

    // reverse the given word
    public String reverse(String word){
        // left -> firt, rigth -> last
        int left = 0;
        int right = word.length()-1;

        StringBuilder sb = new StringBuilder(word);
        // both pointers move on opsite direction
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }

        return sb.toString();
    }

    public static int change(int i){
        i = 5;
        return i;
    }

    /**
     * use two pointers
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //1. transfer the s to char[]
        char[] arr =  s.toCharArray();
        // 2. start -> start of each word;
        int start = 0;

        for(int end = 0; end < arr.length; end++){
            // 3. traverse the s, reverse the word when end point come to " "
            char c = arr[end];
            if(c == ' '){
                reverse(arr, start, end);
                start = end +1;
            }

            if ( end == arr.length-1){
                reverse(arr, start, end+1);
            }
        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int a, int b){
        b--;
        while(a < b){
            char temp =  arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        String str = "God Ding";
        System.out.println(reverseWords1(str));

    }

}
