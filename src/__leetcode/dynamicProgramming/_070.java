package __leetcode.dynamicProgramming;

/**
 * Created by Rain on 2019/6/17.
 */
public class _070 {

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] men = new int[n];
        men[0] = 1;
        men[1] = 2;
        for (int i = 2; i < n; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }
        return men[n - 1];
    }

    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int pre0 = 1;
        int pre1 = 2;
        int sum;
        for (int i = 2; i < n; i++) {
            sum = pre0 + pre1;
            pre0 = pre1;
            pre1 = sum;
        }
        return pre1;
    }


    public static void main(String[] args) {
        //433494437
        System.out.println(climbStairs2(42));
    }
}
