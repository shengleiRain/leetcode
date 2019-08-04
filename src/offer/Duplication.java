package offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ��Ŀ����
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}��
 * ��ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class Duplication {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1 || numbers.length != length) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    // ����ס"��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�"�������
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1 || numbers.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            // ֱ����ǰλ�õ�ֵΪi
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // ����i��numbers[i]��ֵ
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

}
