import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/7/15.
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        move(nums, 18);
        System.out.println(Arrays.toString(nums));
    }

    static void move(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        k %= nums.length;

        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            swap(nums, i, len - i - 1);
        }
        k = k < 0 ? len + k : k;
        for (int i = 0; i < k / 2; i++) {
            swap(nums, i, k - i - 1);
        }
        for (int i = k; i < (len + k) / 2; i++) {
            swap(nums, i, len - i + k - 1);
        }

    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
