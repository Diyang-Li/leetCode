package str;

/**
 * @author Diyang Li
 * @create 2022-07-07 5:04 PM
 */
public class _65_ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean dotSeen = false;

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            // record if seen digits
            if(Character.isDigit(c)){
                numSeen = true;
            }else if(c == 'e' || c == 'E'){
                if(eSeen || !numSeen) return false;
                eSeen = true;
                // if there is no number after e, then return false
                numSeen = false;
            }else if(c == '.'){
                if(eSeen || dotSeen) return false;
                dotSeen = true;
            }else if(c == '-' || c == '+'){
                // if the sign appear in s, must fellow with e
                if(i != 0 && s.charAt(i-1) != 'e') return false;
            }else return false;
        }

        return numSeen;
    }
}
