package str;

/**
 * @author Diyang Li
 * @create 2022-07-14 9:43 AM
 */
public class _686_RepeatedStringMatch {
    /**
     * method 1
     * @param a
     * @param b
     * @return
     */
    public static int repeatedStringMatch(String a, String b) {
        if(a.indexOf(b) != -1) return 1;
        // make sb.length() >= b.length()
        int repeat = b.length() % a.length() == 0? b.length()/a.length() : b.length()/a.length()+1;

        String a1 = "";
        for(int i = 0; i < repeat; i++){
            a1 += a;
        }


        if (a1.indexOf(b) != -1){
            return repeat;
        }else {
            a1 += a;
            return a1.indexOf(b) == -1? -1: repeat+1;
        }
    }

    /**
     * method 2
     * @param a
     * @param b
     * @return
     */
    public static int repeatedStringMatch1(String a, String b) {
        //1. the range of repeat time (a->b length time, a->b length time+1)
        int count = 1;
        StringBuilder sb = new StringBuilder(a);

        // repeat to make sb.length() >= b.length()
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }

        if(sb.indexOf(b) != -1){
            return count;
        }

        sb.append(a);
        count++;

        return sb.indexOf(b) == -1? -1: count;
    }
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdaba";
        System.out.println(repeatedStringMatch(a, b));
        System.out.println((int)Math.ceil((double) b.length()/(double) a.length()));
    }
}
