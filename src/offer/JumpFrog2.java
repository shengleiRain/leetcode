package offer;

/**
 * @author Rain
 * @date 2019/7/15.
 * -------------------------------------------------------------------------------------
 * 变态跳
 * -------------------------------------------------------------------------------------
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * -------------------------------------------------------------------------------------
 */
public class JumpFrog2 {
    public int JumpFloorII(int target) {
        int res = 1;
        for (int i = 1; i < target; i++) {
            res *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFrog2().JumpFloorII(3));
    }
}
