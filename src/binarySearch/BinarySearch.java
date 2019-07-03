package binarySearch;

import java.util.Arrays;

/**
 * @author Rain
 * @date 2019/7/2.
 */
public class BinarySearch {
    /**
     * 返回任意一个满足条件的target的索引位置，如果没找到就返回插入的位置（负数）
     *
     * @param nums   有序数组
     * @param start  有序数组
     * @param end    查找的值
     * @param target 查找的值
     * @return 索引位置or-(插入的位置+1)（负数）
     */

    public static int findAny(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return -(left + 1);
    }

    /**
     * 查找第一个满足的target的位置
     */
    public static int findFirst(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                while (mid != 0 && nums[mid - 1] == target) {
                    mid--;
                }
                return mid;
            }
        }
        return -(left + 1);
    }

    /**
     * 查找最后一个满足的target的位置
     */
    public static int findLast(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                while (mid != right && nums[mid + 1] == target) {
                    mid++;
                }
                return mid;
            }
        }
        return -(left + 1);
    }

    /**
     * 查找第一个大于等于target的位置
     */
    public static int findFirstGreater(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (left <= end) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                while (mid != 0 && nums[mid - 1] >= target) {
                    mid--;
                }
                return mid;
            }
        }
        return -(left + 1);
    }

    public static int findLastLessThan(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        int mid;
        while (start <= end) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                while (mid != right && nums[mid + 1] <= target) {
                    mid++;
                }
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int len = 10;
        int[] nums = new int[len];
        nums[0] = 0;
        for (int i = 1; i < len / 2; i++) {
            nums[i] = 3;
        }
        for (int i = len / 2; i < len; i++) {
            nums[i] = i;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(findAny(nums, 0, nums.length - 1, 11));
        System.out.println(findFirst(nums, 0, nums.length - 1, 3));
        System.out.println(findLast(nums, 0, nums.length - 1, 3));
        System.out.println(findFirstGreater(nums, 0, nums.length - 1, 4));
        System.out.println(findLastLessThan(nums, 0, nums.length - 1, 10));
    }
}
