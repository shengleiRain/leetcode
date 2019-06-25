package __leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rain
 * @date 2019/6/17.
 */
public class _120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] mini = new int[n];
        for (int i = 0; i < mini.length; i++) {
            mini[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
            }
        }
        return mini[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        return minimumRecur(triangle, 1, 1);
    }

    public int minimumRecur(List<List<Integer>> triangle, int row, int column) {
        if (row == triangle.size()) {
            return triangle.get(row - 1).get(column - 1);
        }
        return Math.min(minimumRecur(triangle, row + 1, column),
                minimumRecur(triangle, row + 1, column + 1))
                + triangle.get(row - 1).get(column - 1);
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        _120 solve = new _120();
        System.out.println(solve.minimumTotal(triangle));
        System.out.println(solve.minimumTotal2(triangle));

    }
}
