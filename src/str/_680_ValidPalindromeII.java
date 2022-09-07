package str;

/**
 * @author Diyang Li
 * @create 2022-07-13 3:48 PM
 */
public class _680_ValidPalindromeII {
    /**
     * second method, more straightforward
     * @param s
     * @return
     */
    public boolean validPalindrome1(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }

        if(left > right) return true;
        if(isPali1(s, left+1, right) || isPali1(s, left, right-1)) return true;
        return false;

    }

    public boolean isPali1(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * my way: O(n) O(1)
     * can become more simple: https://www.youtube.com/watch?v=hvI-rJyG4ik
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        //1. two pointer to point left and right
        int left = 0;
        int right = s.length()-1;

        //3. move two pointers in oppsite direction
        while(left < right){
            // if find not same char
            if(s.charAt(left) != s.charAt(right)){
                // remove left one
                // right+1 because substring is[)
                boolean delLeft = isPali(s.substring(left+1, right+1));
                if(!delLeft){
                    // if remove left one cannot be palindrome
                    // then remove the right one
                    boolean delRight = isPali(s.substring(left, right));
                    if(!delRight){
                        // if both are false, just return false;
                        return false;
                    }else{
                        return true;
                    }
                }else{
                    return true;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean isPali(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abcda";
        _680_ValidPalindromeII t = new _680_ValidPalindromeII();
        t.validPalindrome(s);

    }
}
