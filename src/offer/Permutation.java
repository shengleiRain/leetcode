package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * ��Ŀ����
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
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
