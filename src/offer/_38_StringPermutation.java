package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rain
 * @date 2019/9/21.
 */
public class _38_StringPermutation {

    public static void main(String[] args) {
        permutation("aa", 0);
        System.out.println(list.toString());
    }

    private static List<String> list = new ArrayList<>();

    public static void permutation(String str, int begin) {
        if (begin == str.length()) {
            list.add(str);
            return;
        }
        char firstChar = str.charAt(begin);
        for (int i = begin; i < str.length(); i++) {
            if (firstChar != str.charAt(i) || i == begin) {
                char[] tempArr = str.toCharArray();
                tempArr[begin] = tempArr[i];
                tempArr[i] = firstChar;
                permutation(new String(tempArr), begin + 1);
            }
        }
    }
}
