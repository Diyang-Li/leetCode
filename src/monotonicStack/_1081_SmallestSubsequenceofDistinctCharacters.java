package monotonicStack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Diyang Li
 * @create 2022-08-28 1:10 PM
 */
public class _1081_SmallestSubsequenceofDistinctCharacters {
    // if the letter in the back is smaller then the front, also the front letter is not the last one, pop from stack
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        // record the last position of each distinct char in s
        // 判断是否可以移除当前char，因为如果是last，被移除的话，不能保证最后的结果包括所有的char
        // HashMap用来calculate频率，错的写法用了hashmap
        for(int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        // make sure the char in stack are all distinct
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            // if there is cur in stack, means on the right place currently,
            // don't need to remove, continue to next char
            if(!set.add(cur)) continue;
            // if i > last[stack.peek() - 'a'], means the i has over the last position of stack.peek(), so cannot be popped
            while(!stack.isEmpty() && cur < stack.peek() && i < last[stack.peek() - 'a']) set.remove(stack.pop());
            stack.push(cur);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack) sb.append(c);

        return sb.toString();
    }
}
