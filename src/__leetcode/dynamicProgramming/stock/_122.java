package __leetcode.dynamicProgramming.stock;

/**
 * @author Rain
 * @date 2019/6/18.
 * 股票可以买卖无数次
 */
public class _122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                profit += prices[i] - pre;
            }
            pre = prices[i];
        }
        return profit;

    }

    public static void main(String[] args) {
        _122 solve = new _122();
        int[] prices = {7, 2, 1, 5, 3, 6, 4};
        System.out.println(solve.maxProfit(prices));
    }
}
