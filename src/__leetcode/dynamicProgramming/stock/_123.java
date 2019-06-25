package __leetcode.dynamicProgramming.stock;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/6/18.
 */
public class _123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int hold1 = -prices[0];
        int hold2 = -prices[0];
        int release1 = 0;
        int release2 = 0;

        for (int i = 1; i < len; i++) {
            //仍然保持上一个释放状态或者第一次卖出
            release1 = Math.max(release1, hold1 + prices[i]);
            hold1 = Math.max(hold1, -prices[i]);
            release2 = Math.max(release2, hold2 + prices[i]);
            hold2 = Math.max(hold2, release1 - prices[i]);
        }
        return release2;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[] hold = new int[3];
        int[] release = new int[3];
        Arrays.fill(hold, Integer.MIN_VALUE);
        Arrays.fill(release, 0);

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= 2; j++) {
                hold[j] = Math.max(hold[j], release[j - 1] - prices[i]);
                release[j] = Math.max(release[j], hold[j] + prices[i]);
            }
        }
        return release[2];
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;
        int[][] clear = new int[len][3];//clear
        int[][] hold = new int[len][3];//hold
        for (int j = 1; j <= 2; j++) {
//            int tempMax = -prices[0];//hold
            hold[0][j]=-prices[0];
            for (int i = 1; i < len; i++) {
//                clear[i][j] = Math.max(clear[i - 1][j], tempMax + prices[i]);
//                tempMax = Math.max(tempMax, clear[i - 1][j - 1] - prices[i]);
                clear[i][j]=Math.max(clear[i-1][j],hold[i-1][j]+prices[i]);
                hold[i][j]=Math.max(hold[i-1][j],clear[i-1][j-1]-prices[i]);
            }
        }
        return clear[len - 1][2];
    }

    public static void main(String[] args) {
        _123 solve = new _123();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(solve.maxProfit(prices));
        System.out.println(solve.maxProfit2(prices));
        System.out.println(solve.maxProfit3(prices));
    }
}
