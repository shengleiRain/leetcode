package offer;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * <p>
 * 解法：
 * 1, 根据题设中的一个数字出现的次数超过数组长度的一半，那么可以先遍历一次array，记录下第一个位置为prev，计数值count=1，
 * 从index=1开始，每个数字与prev比较，如果相同，则count++，如果不相同，则将count--，当count减到0后，就将prev的值赋值为当前数字，
 * 并且将count=1；
 * 2，由于不一定存在这样的数字，所以，需要遍历一次array，得到的prev值的个数，如果超过一半，则返回prev，否则为0
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1, prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prev == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    prev = array[i];
                    count = 1;
                }
            }
        }

        int prevCount = 0;
        if (count > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == prev) {
                    prevCount++;
                }
            }
        }


        return 2 * prevCount > array.length ? prev : 0;

    }
}
