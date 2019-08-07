package offer;

import java.util.ArrayList;

/**
 * @author Rain
 * @date 2019/8/7.
 * <p>
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || size == 0) {
            return new ArrayList<>();
        }
        size = Math.min(num.length, size);
        ArrayList<Integer> result = new ArrayList<>(num.length - size + 1);
        // 用于记录上一个滑动窗口的最大值index
        int maxIndex = -1;
        for (int i = 0; i <= num.length - size; i++) {
            int max = num[i];
            if (maxIndex != -1 && i <= maxIndex) {
                max = num[maxIndex];
            }
            for (int j = i; j < i + size; j++) {
                if (j < num.length) {
                    if (max < num[j]) {
                        maxIndex = j;
                    }
                    max = Math.max(max, num[j]);
                }
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SlideWindow().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 7));
    }
}
