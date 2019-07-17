package offer;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/7/16.
 * -------------------------------------------------------------------------------------
 * 调整数组顺序使奇数位于偶数前面
 * -------------------------------------------------------------------------------------
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * -------------------------------------------------------------------------------------
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int oddIndex = 0, evenIndex = 0;
        for (int anArray : array) {
            if (anArray % 2 == 1) {
                //将奇数插到偶数前面
                insertOdd(array, evenIndex, oddIndex);
                evenIndex++;
            } else {
                if (array[evenIndex] % 2 == 1) {
                    evenIndex++;
                }
            }
            oddIndex++;

        }
    }

    private void insertOdd(int[] array, int evenIndex, int oddIndex) {
        if (evenIndex >= oddIndex) {
            return;
        }
        int temp = array[oddIndex];
        for (int i = oddIndex; i > evenIndex; i--) {
            array[i] = array[i - 1];
        }
        array[evenIndex] = temp;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new ReOrderArray().reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
