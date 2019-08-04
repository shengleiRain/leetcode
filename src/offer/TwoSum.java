package offer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class TwoSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Integer[] result = new Integer[2];
        int mux = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            int target = sum - array[i];
            if (target < array[i]) {
                break;
            }
            int otherIndex = find(array, i + 1, array.length, target);
            if (otherIndex != -1 && array[i] * array[otherIndex] < mux) {
                result[0] = array[i];
                result[1] = array[otherIndex];
                mux = array[i] * array[otherIndex];
            }
        }
        if (mux == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(result));
    }

    private int find(int[] array, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < j) {
            if (array[i] + array[j] == sum) {
                result.add(array[i]);
                result.add(array[j]);
                break;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }

        }
        return result;
    }
}
