package __leetcode.dynamicProgramming;

/**
 * Created by Rain on 2019/6/17.
 */
public class _152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] minusMax = new int[nums.length];
        int res = nums[0];
        max[0] = minusMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], minusMax[i - 1] * nums[i]), nums[i]);
            minusMax[i] = Math.min(Math.min(max[i - 1] * nums[i], minusMax[i - 1] * nums[i]), nums[i]);
        }

        for (int num : max) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        _152 solve = new _152();
        int[] nums = {2, 3, -2, 4, 0};
        System.out.println(solve.maxProduct(nums));
    }
}
