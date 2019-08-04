package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        // 7以下的数字，本身就是丑数
        if (index < 7) {
            return index;
        }

        int[] uglys = new int[index];
        uglys[0] = 1;
        //  表示用于分别乘以2，3，5的最小数字
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
