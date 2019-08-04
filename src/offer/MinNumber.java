package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
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
