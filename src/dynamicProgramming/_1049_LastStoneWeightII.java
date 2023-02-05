package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2023-01-12 12:06 PM
 */
public class _1049_LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num: stones){
            sum += num;
        }

        int target = sum/2;
        int[] dp = new int[target+1];
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - 2*dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        _1049_LastStoneWeightII t = new _1049_LastStoneWeightII();
        t.lastStoneWeightII(arr);
        char c = (char)(1 + 'A');
        System.out.println(c);
    }
}
