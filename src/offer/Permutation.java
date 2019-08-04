package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null && str.length() > 0) {
            helper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }
        return result;
    }

    private void helper(char[] chars, int i, ArrayList<String> result) {
        if (i == chars.length - 1) {
            result.add(new String(chars));
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    helper(chars, i + 1, result);
                    swap(chars, i, j);
                }
            }
        }

    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
