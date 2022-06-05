import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author Diyang Li
 * @create 2022-06-01 12:00 AM
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    /**
     * O(n) O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        // hashmap to record the position of each char
        HashMap<Character, Integer> record = new HashMap<>();
        int len = 0;
        // slow pointer and fast pointer
        //{}
        for (int slow = 0, fast = 0; fast < s.length(); fast++){
            if(record.containsKey(s.charAt(fast))){
                // 这里出取max是因为 如果abba: fast comes to last a, but the a in record is a: 0;
                //所以如果出现这样的情况，slow pointer停留在原地不动
                // slow fast 都只能前进不能后退，如果之前的那个char没更新，就只能让slow停留在原地
                slow = Math.max(record.get(s.charAt(fast))+1, slow);
            }
            record.put(s.charAt(fast), fast);
            len = Math.max(len, fast-slow+1);
        }

        return len;
    }
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
