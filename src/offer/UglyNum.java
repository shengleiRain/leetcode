package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ����
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        // 7���µ����֣�������ǳ���
        if (index < 7) {
            return index;
        }

        int[] uglys = new int[index];
        uglys[0] = 1;
        //  ��ʾ���ڷֱ����2��3��5����С����
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            int num2 = uglys[i2] * 2;
            int num3 = uglys[i3] * 3;
            int num5 = uglys[i5] * 5;
            int min = Math.min(num2, Math.min(num3, num5));
            uglys[i] = min;
            if (min == num2) i2++;
            if (min == num3) i3++;
            if (min == num5) i5++;
        }
        return uglys[index - 1];


    }
}
