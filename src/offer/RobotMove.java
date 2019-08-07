package offer;

/**
 * @author Rain
 * @date 2019/8/7.
 * <p>
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        if (threshold == 0) {
            return 1;
        }
        boolean[][] flag = new boolean[rows][cols];
        return helper(threshold, rows, cols, 0, 0, flag);
    }

    private int helper(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] flag) {
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols || cal(curRow, curCol) > threshold || flag[curRow][curCol]) {
            return 0;
        }
        flag[curRow][curCol] = true;
        return helper(threshold, rows, cols, curRow, curCol + 1, flag) +
                helper(threshold, rows, cols, curRow, curCol - 1, flag) +
                helper(threshold, rows, cols, curRow - 1, curCol, flag) +
                helper(threshold, rows, cols, curRow + 1, curCol, flag) + 1;
    }

    private int cal(int curRow, int curCol) {
        return calculateK(curRow) + calculateK(curCol);
    }

    private int calculateK(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RobotMove().movingCount(5, 10, 10));
    }
}
