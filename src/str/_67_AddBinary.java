package str;

/**
 * @author Diyang Li
 * @create 2022-07-09 12:00 PM
 */
public class _67_AddBinary {
    /**
     * the solution of this problem really like the _2_AddTwoNumbers in array
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int ap = a.length()-1;
        int bp = b.length()-1;

        int sum = 0;

        while(ap >= 0 || bp>=0){
            if(ap >= 0){
                sum += a.charAt(ap) - '0';
                ap--;
            }

            if(bp >= 0){
                sum += b.charAt(bp) - '0';
                bp--;
            }

            sb.append(sum % 2);
            sum /= 2;
        }

        if(sum > 0){
            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
