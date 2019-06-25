package __leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/23.
 */
public class _322 {
    // 动态规划
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin]) + 1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 暴力求解
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length <= 0) return -1;
        return coinChange2(0, coins, amount);
    }

    private int coinChange2(int idxCoin, int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        if (idxCoin<coins.length&&amount>0){
            int maxVal = amount/coins[idxCoin];
            int min=Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                int res = coinChange2(idxCoin+1, coins, amount-i*coins[idxCoin]);
                if (res!=-1){
                    min=Math.min(res+i,min);
                }
            }
            return (min==Integer.MAX_VALUE)?-1:min;
        }
        return -1;
    }

    // 从上至下，递归加缓存
    public int coinChange3(int[] coins, int amount) {
        if (coins == null || coins.length <= 0) return -1;
        int[] cache = new int[amount];
//        Arrays.fill(cache,0);
        return coinChange3(coins, amount,cache);
    }

    private int coinChange3(int[] coins, int amount, int[] cache) {
        if (amount<0) return -1;
        if (amount==0) return 0;
        if (cache[amount-1]!=0) return cache[amount-1];
        int minCost=Integer.MAX_VALUE;
        for (int coin:coins){
            int res=coinChange3(coins, amount-coin, cache);
            if (res>=0&&res<minCost){
                minCost=res+1;
            }
        }
        cache[amount-1]=(minCost==Integer.MAX_VALUE)?-1:minCost;
        return cache[amount-1];

    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new _322().coinChange(coins, amount));
        System.out.println(new _322().coinChange2(coins, amount));
        System.out.println(new _322().coinChange3(coins, amount));
    }
}
