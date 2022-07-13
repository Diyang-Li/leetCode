package str;

/**
 * @author Diyang Li
 * @create 2022-07-13 12:25 PM
 */
public class _125_ValidPalindrome {
    /**
     * tow pointers O(n)
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        //1. left  right pointer
        int left = 0;
        int right = s.length()-1;

        //2. move both pointer in opsite direction
        while(left < right){
            while (left < right &&!(Character.isDigit(s.charAt(left))||Character.isLetter(s.charAt(left)))){
                left++;
            }

            while (left < right &&!(Character.isDigit(s.charAt(right))||Character.isLetter(s.charAt(right)))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
               return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String  s = "A man, a plan, a canal: Panama";
        String s2 = ".,";
        System.out.println(isPalindrome(s2));
    }
}
