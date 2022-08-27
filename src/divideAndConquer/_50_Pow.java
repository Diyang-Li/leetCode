package divideAndConquer;

/**
 * @author Diyang Li
 * @create 2022-08-26 12:45 PM
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        return n > 0? divide(x, n): 1/divide(x, -n);
    }

    private double divide(double x, int n){
        if(n == 0) return 1;

        double y = divide(x, n/2);
        // System.out.println(y + " " + x + " "+ n);
        if(n%2 == 0) return y * y;
        else return x * y * y;
    }
}
