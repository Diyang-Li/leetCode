package str;

/**
 * @author Diyang Li
 * @create 2022-07-10 11:39 AM
 */
public class _43_MultiplyStrings {
    /**
     * my method, very complexed, totally brut force and bad name O(n^2)
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        //1. seperate teh long and short numw for convinence
        String l = num1.length() >= num2.length()? num1: num2;
        String s = l == num1? num2: num1;

        String layerRes = "";
        String multi = "";

        // l * s
        // traverse each num of short to multy num of longer
        for(int i = s.length()-1; i >= 0; i--){
            StringBuilder rest = new StringBuilder();
            int tempRes = 0; // if the result > 10, +1
            for(int j = l.length()-1; j>=0; j--){
                int temp = (s.charAt(i) - '0') * (l.charAt(j) - '0') + tempRes;
                tempRes = temp/10;
                rest.append(temp%10);
            }
            if (tempRes > 0){
                rest.append(tempRes);
            }
            String tempLayerRestult = rest.reverse().toString() + multi;
            multi += "0";

            int i1 = layerRes.length()-1;
            int j1 = tempLayerRestult.length()-1;
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            while(i1>=0 || j1>=0){
                if(i1 >= 0){
                    sum += layerRes.charAt(i1) - '0';
                    i1--;
                }

                if(j1 >= 0){
                    sum += tempLayerRestult.charAt(j1) - '0';
                    j1--;
                }

                sb.append(sum % 10);
                sum/=10;
            }

            if(sum > 0){
                sb.append(sum);
            }
            layerRes = sb.reverse().toString();
        }

        return layerRes;
    }

    /**
     * A better method, different multiply way different from we learnt before
     * @param num1
     * @param num2
     * @return
     */

    public String multiply1(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        // The length of result equals to the sum of two numbers' length;
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) {
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        String num1 = "23";
        String num2 = "56";
        System.out.println(multiply(num1, num2));
    }
}
