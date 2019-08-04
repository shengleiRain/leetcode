package structure.tree;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public class Test {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        move(nums, 3);
        System.out.println(Arrays.toString(nums));

    }

    static void move(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            res[i] = nums[(i + k - 1) % nums.length];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);

    }

    static void move2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }


    }


}
