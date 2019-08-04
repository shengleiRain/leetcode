package offer;

import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        if (str.length() == 1) {
            return 0;
        }


        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            } else {
                map.put(ch, -1);
            }
        }
        int index = str.length();
        for (int value : map.values()) {
            if (value != -1) {
                index = Math.min(index, value);
            }
        }
        return index == str.length() ? -1 : index;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("google"));
    }
}
