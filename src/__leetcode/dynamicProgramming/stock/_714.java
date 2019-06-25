package __leetcode.dynamicProgramming.stock;

/**
 * @author Rain
 * @date 2019/6/18.
 */
public class _714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < len; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }
        return sell;
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < len; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        }
        return sell[len - 1];
    }

    // greedy 貌似得不到最优解
    public int maxProfit3(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            min = Math.min(price, min);
            int curProfit = price - min - fee;
            if (curProfit > 0) {
                profit += curProfit;
                min = price;
            }

        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = {1,3,7,5,10,3};
        int fee = 3;
        System.out.println(new _714().maxProfit(prices, fee));
        System.out.println(new _714().maxProfit2(prices, fee));
        System.out.println(new _714().maxProfit3(prices, fee));
    }

}
