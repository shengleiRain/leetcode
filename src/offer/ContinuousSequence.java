package offer;

import java.util.ArrayList;

/**
 * ��Ŀ����
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������?
 * Good Luck!
 */
public class ContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= sum / 2; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            int tempSum = 0;
            for (int j = i; j <= sum / 2 + 1; j++) {
                item.add(j);
                tempSum += j;
                if (tempSum == sum) {
                    result.add(item);
                } else if (tempSum > sum) {
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        while (low < high) {
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> item = new ArrayList<>();
                for (int i = low; i < high; i++) {
                    item.add(i);
                }
                result.add(item);
                low++;
            } else if (cur > sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }
}
