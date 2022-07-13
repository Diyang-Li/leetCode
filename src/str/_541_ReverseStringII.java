package str;

/**
 * @author Diyang Li
 * @create 2022-07-12 4:50 PM
 */
public class _541_ReverseStringII {
    public static String reverseStr(String s, int k) {
        int p1 = 0;
        int p2 = 0;

        char[] arr = s.toCharArray();


        int mod = arr.length/k;

        // if i is odd, need to reverse
        // if i is even, don't need reverse
        int i = 1;

        while(i <= mod){
            for(int j =0 ;j < k-1; j++){
                p2++;
            }

            if(i%2 != 0){
                reverse(arr, p1, p2);
            }
            p1 = ++p2;

            i++;
        }

        //if p2 hasn't come to the end of the array, also the mod is even
        // the rest array needs to be reversed
        if(mod % 2 == 0 && p2 < arr.length){
            reverse(arr, p1, arr.length-1);
        }

        return new String(arr);
    }

    public static void reverse(char[] arr, int a, int b) {
        while (a < b) {
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 4;
        System.out.println(reverseStr(s, k));
    }
}
