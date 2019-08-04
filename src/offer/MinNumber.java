package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinNumber {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else if (o1.length() < o2.length()) {
                    return myCompare(o1, o2);
                } else {
                    return -myCompare(o2, o1);
                }
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String str : numStrs) {
            builder.append(str);
        }
        return builder.toString();
    }

    private int myCompare(String o1, String o2) {
        for (int i = 0; i < o2.length(); i++) {
            if (i >= o1.length()) {
                if (o1.charAt(o1.length() - 1) != o2.charAt(i)) {
                    return o1.charAt(o1.length() - 1) - o2.charAt(i);
                }
            } else {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
        }
        return 0;
    }

}
