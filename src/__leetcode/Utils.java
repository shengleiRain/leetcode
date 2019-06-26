package __leetcode;

/**
 * @author Rain
 * @date 2019/6/26.
 */
public class Utils {
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
