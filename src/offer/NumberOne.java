package offer;

/**
 * @author Rain
 * @date 2019/7/16.
 * <p>
 * -------------------------------------------------------------------------------------
 * 二进制中1的个数
 * -------------------------------------------------------------------------------------
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * -------------------------------------------------------------------------------------
 */
public class NumberOne {

    public int NumberOf1(int n) {
        int count = 0;
        if (n == 0) {
            return count;
        }
        if (n < 0) {
            n = ~((-n) & 0x7fffffff) + 1;
            count++;
        }
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 0x01) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = -10; i < 0; i++) {
            System.out.println(new NumberOne().NumberOf1(i));
        }

    }
}
