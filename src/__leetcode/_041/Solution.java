package __leetcode._041;

/**
 * Created by Rain on 2019/5/26.
 */
public class Solution {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4, -1, -1, 0, -1, -4, 2, 3};
//        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists);

        int[] nums = {5,-4,3,4,2,-1};
        System.out.println(firstMissingPositive(nums));
    }
}
