package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SingleNumbers {
    /**
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 1) {
            return;
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int orNum = 0;
        for (int num : array) {
            orNum ^= num;
        }
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            if (((orNum >> bit) & 0x01) == 0) {
                bit++;
            } else {
                break;
            }
        }
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int num : array) {
            if ((num & (0x01 << bit)) == 0) {
                arr1.add(num);
            } else {
                arr2.add(num);
            }
        }
        for (int num : arr1) {
            num1[0] ^= num;
        }
        for (int num : arr2) {
            num2[0] ^= num;
        }
    }

    /**
     * Given a non-empty array of integers,
     * every element appears three times except for one,
     * which appears exactly once. Find that single one.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 2) {
                map.remove(num);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return (int) map.keySet().toArray()[0];

    }

    public static void main(String[] args) {
        new SingleNumbers().FindNumsAppearOnce(new int[]{2, 3, 3, 4, 6, 2}, new int[1], new int[1]);
    }
}
