package str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-09-20 4:56 PM
 */
public class _290_WordPattern {
    /**
     * use two hashmap, there is another method just use one hashmap
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        String[] strs = s.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }

        int len = strs.length;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < len; i++){
            char c = pattern.charAt(i);
            String str = strs[i];
            if(map1.containsKey(c) ){
                if(!map1.get(c).equals(str)){
                    return false;
                }
            }else {
                if(map2.containsKey(str) && map2.get(str) != c){
                    return false;
                }
            }
            map1.put(c, str);
            map2.put(str,c);
        }

        return true;

    }
}
