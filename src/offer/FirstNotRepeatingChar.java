package offer;

import java.util.HashMap;

/**
 * ��Ŀ����
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
 * ���û���򷵻� -1����Ҫ���ִ�Сд��.
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
