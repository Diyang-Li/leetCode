package str;

import java.util.Map;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-09-25 11:17 PM
 */
public class _20_ValidParentheses {
    private static final Map<Character, Character> map = Map.of(')', '(',
            ']', '[',
            '}', '{');
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(map.get(c) != stack.pop()){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
