package __leetcode.dynamicProgramming;

/**
 * @author Rain
 * @date 2019/6/23.
 */
public class _072 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j]代表前i个word1与前j个word2的最少编辑次数
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 插入、删除、替换
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        System.out.println(new _072().minDistance("horse","ros"));
    }
}
