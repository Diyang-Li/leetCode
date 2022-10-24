package str;

import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-10-17 2:45 PM
 */
public class _844_BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        helper(s, stack1);
        helper(t, stack2);

        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
        while (!stack1.isEmpty()){
            ss.append(stack1.pop());
        }

        while (!stack2.isEmpty()){
            st.append(stack2.pop());
        }

        s = new String(ss);
        t = new String(st);
        return s.equals(t);
    }

    private void helper(String s, Stack<Character> stack){
        for(int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '#'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
    }
}
