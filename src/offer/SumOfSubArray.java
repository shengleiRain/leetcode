package offer;

/**
 * ���������������
 */
public class SumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int maxSum = array[0], temp = array[0];

        for (int i = 1; i < array.length; i++) {
            temp = Math.max(temp + array[i], array[i]);
            maxSum = Math.max(maxSum, temp);
        }
        return maxSum;
    }

}
