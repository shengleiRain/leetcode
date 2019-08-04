package offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
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
