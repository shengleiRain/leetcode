package __leetcode._005;

/**
 * Created by Rain on 2019/6/11.
 */
public class Solution {

    /**
     * 暴力解法
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int maxStart = 0, maxEnd = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isValid(s, i, j)) {
                    if (j - i > maxEnd - maxStart) {
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * 左闭右闭
     */
    private static boolean isValid(String s, int start, int end) {
        int range = (end - start + 1) / 2;
        for (int i = 0; i < range; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dabccba";
        System.out.println(longestPalindrome(s));
//        System.out.println(isValid(s,1,s.length()-2));
    }
}
