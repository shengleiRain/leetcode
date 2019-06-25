package __leetcode.dynamicProgramming.stock;

/**
 * @author Rain
 * @date 2019/6/18.
 */
public class _188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        int len = prices.length;
        if (k > len / 2) return quickSolve(prices);
        int[][] mp = new int[k + 1][len];//股票清空
        for (int kk = 1; kk <= k; kk++) {
            int tempMax = -prices[0];//手中持有一只股票
            for (int i = 1; i < len; i++) {
                mp[kk][i] = Math.max(mp[kk][i - 1], prices[i] + tempMax);
                tempMax = Math.max(tempMax, mp[kk - 1][i - 1] - prices[i]);
            }
        }
        return mp[k][len - 1];
    }

    /**
     * 相当于使用无限次买卖
     */
    private int quickSolve(int[] prices) {
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

    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        int len = prices.length;
        if (k > len / 2) return quickSolve(prices);
        //以交易次数进行缓存记录最高收益
        int[] buys = new int[k + 1];//没有股票在手上
        int[] sells = new int[k + 1];//有一只股票在手上
        for (int i = 0; i < buys.length; i++) {
            buys[i] = -prices[0];
        }
        for (int i = 0; i < sells.length; i++) {
            sells[i] = 0;
        }
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buys[i] = Math.max(buys[i], sells[i - 1] - price);
                sells[i] = Math.max(sells[i], buys[i] + price);
            }
        }
        return sells[k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(new _188().maxProfit2(k, prices));
    }
}
