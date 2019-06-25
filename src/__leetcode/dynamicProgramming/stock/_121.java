package __leetcode.dynamicProgramming.stock;

/**
 * @author Rain
 * @date 2019/6/18.
 */
public class _121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0];//记录下最小值
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > 0) {
                profit = Math.max(profit, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        _121 solve = new _121();
        int[] prices = {7, 2, 100, 1, 5, 101, 3, 6, 4};
        System.out.println(solve.maxProfit(prices));
    }
}
