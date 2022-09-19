package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2022-09-18 11:27 PM
 */
public class _322_CoinChange {
    // fewest number of coins amount--> dp
    // O(amount * num of denominations)
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        int len = coins.length;

        // initialization
        f[0] = 0;

        // Note the start point is 1
        for(int i = 1; i <= amount; i++){
            f[i] = Integer.MAX_VALUE;

            for(int j = 0; j < len; j++){
                // Important condition
                if(coins[j] <= i && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i], f[i - coins[j]]+1);
                }
            }
        }

        if(f[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return f[amount];
        }
    }
}
