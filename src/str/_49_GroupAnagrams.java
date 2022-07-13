package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-07-13 10:06 AM
 */
public class _49_GroupAnagrams {
    /**
     * O(m * nlogn) O(n)
     * About this problem, when we just concern the frequency of each letter in the word
     * we could sort the word
     * the time complexity of Arrays.sort() is O(n*logn)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }

        List<List<String>> rest = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); // key: sorted word, value: index of the list that contains the key in the rest List
        //1. traverse the strs, order each word
        for (String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String strSort = new String(c);
            //2. if the sorted word in the map, get index of the list in the rest, and put the word that not sorted in the list
            if(map.containsKey(strSort)){
                List<String> list = rest.get(map.get(strSort));
                list.add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(strSort, rest.size());
                rest.add(list);
                //3. if the sorted word not in the map, new a list and put the not sorted in the list, then add the list to the rest;
            }
        }
        return rest;
    }

    /**
     * use count[26] to count the frequency of each letter
     * O(n * m) O(n)
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        // key: 1a1e1t, value: {"eat"}
        HashMap<String, List<String>> map = new HashMap<>();

        // 1. traverse the strs ["eat","tea","tan","ate","nat","bat"]
        for(String str: strs){
            // 2. count[26]
            int[] count = new int[26]; // to count the frequency of each letter in a word
            // 3. traverse each word, and make number index of the char in the count array represent the frequency
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }

            String word = "";
            // 4. traverse the count array, concat the frequency and the letter --> 1a1e1t
            for(int j = 0; j < 26; j++){
                if(count[j] != 0){
                    word +=  String.valueOf(count[j]) +String.valueOf((char)(j + 'a'));
                }
            }
            // 5. if key in the map, get list and add the "eat " the list
            if(map.containsKey(word)){
                List<String> list = map.get(word);
                list.add(str);
            }else{
                // 6. not in the map, new list, then put the "eat" in the new list, then put the ("eat", new list) to the map;
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(word, list);
            }
        }
        // 7. return the list of the value of the map;
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan"};
        groupAnagrams1(strs);
    }
}
