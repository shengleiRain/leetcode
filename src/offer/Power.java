package offer;

/**
 * @author Rain
 * @date 2019/7/16.
 * -------------------------------------------------------------------------------------
 * 数值的n次方
 * -------------------------------------------------------------------------------------
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * -------------------------------------------------------------------------------------
 * 采用递归的方式
 */
public class Power {
    public double power(double base, int n) {
        if (base == Integer.MIN_VALUE && n > 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            base = 1 / base;
        }
        return n % 2 == 0 ? power(base * base, n / 2) : base * power(base * base, n / 2);
    }
}
