package bfs;

import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-08-22 4:03 PM
 */
public class _127_WordLadder {
    /**
     * general bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int step = 1;
        int len = beginWord.length();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)) return step;
                for(int j = 0; j < len; j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(j, c);
                        String newCur = sb.toString();
                        if(set.contains(newCur)){
                            if(newCur.equals(endWord)) return step+1;
                            q.offer(newCur);
                            System.out.println(newCur + " " + step);
                            set.remove(newCur);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * Bidirectional DFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord)) return 0;

        int step = 1;
        int len = beginWord.length();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> nextSet = new HashSet<>();
            for(String word: beginSet){
                char[] chs = word.toCharArray();
                for(int i = 0; i < len; i++){
                    for(char j = 'a'; j <= 'z'; j++){
                        char pre = chs[i];
                        chs[i] = j;
                        String newWord = new String(chs);
                        if(endSet.contains(newWord)) {
                            return step+1;
                        }
                        if(visited.add(newWord) && words.contains(newWord)){
                            nextSet.add(newWord);
                        }
                        chs[i] = pre;
                    }
                }
            }

            // key points
            if(endSet.size() < nextSet.size()){
                beginSet = endSet;
                endSet = nextSet;
            }else{
                beginSet = nextSet;
            }

            step++;
        }

        return 0;
    }

}
