import java.util.HashMap;

/**
 * @author Diyang Li
 * @create 2022-06-01 9:21 PM
 */
public class _567_PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        // 1.frequency 出现的种类和次数相同
        // 2. 长度相同

        int pLen = s1.length();
        int tLen = s2.length();
        //1. 打成char[]
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        // 2. int[] 记录frequency
        int[] pFreq = new int[26];
        int[] tFreq = new int[26];

        // 3.找到s1每个letter frequency: 记录的是次数
        for (int i = 0; i < pLen; i++) {
            // 'a' = 123 位移，记住
            pFreq[pattern[i] - 'a']++;
        }

        // 4. s1每个letter的种类
        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        // 5. 开始对s2进行sliding window operation
        // left 用来比较种类，调整tFreq种char出现的次数，以及和right相减计算len
        int left = 0;
        // right 记录走过的地方，出现在pFreq种的char的frequency，并且记录winCount种类
        int right = 0;
        // 记录window中的种类
        int tCount = 0;
        while (right < tLen) {
            //第一层if说明在pFreq中是存在text[right]位置上的char的
            if (pFreq[text[right]-'a']>0){
                tFreq[text[right] -'a']++;
                if (tFreq[text[right] -'a'] == pFreq[text[right] -'a']){
                    //既然是char一样，frequency一样的话，那么可以说是符合pFreq中的一个种类了
                    tCount++;
                }
            }
            // 为什么不在最后++?
            // 假如是left来到了符合的位置的第一个字母，right-left要right在符合的substring的最后一个char之后才可以算出正确长度
            right++;

            //处理left
            // 首先right要手机号符合条件的所有的种类，才可以触发left的移动
            // 这个事实上就是在控制每个target char要相邻
            while (pCount == tCount){
                //种类相同+长度相同，return ture
                if (right - left == pLen){
                    return true;
                }
                // left的char是有的，但是数目和pFreq是不一样的，left remove的过程中要减下去，总能减到和pFreq中相同的时候
                if (pFreq[text[left]-'a'] > 0){
                    tFreq[text[left]-'a'] --;
                    //如果数量小于pFreq的时候，right前就完全不能让这个char再和pfreq中的相同了，所以pcount中去掉；
                    // 接下来pCount == tCount就不会成立，right会继续remove
                    if (tFreq[text[left]-'a'] < pFreq[text[left]-'a']){
                        tCount--;
                    }
                }
                left++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ky";
        String s2 = "ainwkckifykxlribaypk";
        System.out.println(checkInclusion(s1, s2));
    }
}
