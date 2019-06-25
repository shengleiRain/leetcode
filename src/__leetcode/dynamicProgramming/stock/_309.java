package __leetcode.dynamicProgramming.stock;

/**
 * @author Rain
 * @date 2019/6/18.
 */
public class _309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int delay = 0;
        for (int price : prices) {
            buy = Math.max(buy, delay - price);
            delay = sell;
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[] sell = new int[len];//记录卖出时每天的最大值
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        int buy = Math.max(-prices[0], -prices[1]);//记录买入的最大值
        for (int i = 2; i < len; i++) {
            //之前已经卖出或者当天卖出
            sell[i] = Math.max(sell[i - 1], prices[i] + buy);
            //之前已经买入或者前两天有卖出
            buy = Math.max(buy, sell[i - 2] - prices[i]);
        }
        return sell[len - 1];

    }

    public static void main(String[] args) {
        _309 solve = new _309();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(solve.maxProfit(prices));
    }
}
