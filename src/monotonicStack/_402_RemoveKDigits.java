package monotonicStack;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-28 1:59 PM
 */
public class _402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //The most important is that the increasing order
        // so remove k element first and find the first k incresing order
        Stack<Character> stack = new Stack<>();
        for(char c: num.toCharArray()){
            while(!stack.isEmpty() && c < stack.peek() && k > 0){
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // now the first k emlement are increasing
        // need to remove k elements(relative largest elements in the array)
        while(k > 0) {
            k--;
            stack.pop();
        }
        // method to remove first few 0 in a String
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(int i: stack){
            if(i == '0' && zero) continue;
            else zero = false;
            sb.append(i - '0');
        }

        return sb.length() == 0? "0" : sb.toString();
    }
}
