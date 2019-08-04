package offer;

import java.util.HashSet;

/**
 * ��Ŀ����
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
 * ������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 * ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 */
public class Continuous {
    public boolean isContinuous(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num == 0) {
                zeroCount++;
            } else {
                if (set.contains(num)) {
                    return false;
                } else {
                    set.add(num);
                    min = Math.min(num, min);
                    max = Math.max(num, max);
                }
            }
        }
        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
            return zeroCount > 0;
        } else {
            return zeroCount + set.size() >= (max - min - 1);
        }
    }
}
