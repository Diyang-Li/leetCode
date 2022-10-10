package dynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Diyang Li
 * @create 2022-10-08 12:06 PM
 */
public class _121_BestTimetoBuyandSellStock {
    // use monotone queue, very slow
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        Deque<Integer> q = new LinkedList<>();
        int res = 0;
        q.offer(0);
        int p = 1;
        while(p < prices.length){
            int cur = prices[p];
            while(!q.isEmpty() && prices[q.peekLast()] > cur){
                q.pollLast();
            }
            q.offerLast(p);
            res = Math.max(res, prices[q.peekLast()] - prices[q.peekFirst()]);
            p++;
        }
        return res;
    }
    // O(n) O(1)
    public int maxProfit1(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else{
                res = Math.max(res, prices[i] - minPrice);
            }
        }

        return res;
    }
}
