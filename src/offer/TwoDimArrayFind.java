package offer;

/**
 * @author Rain
 * @date 2019/7/15.
 * <p>
 * -------------------------------------------------------------------------------------------------------
 * 二维数组的查找
 * -------------------------------------------------------------------------------------------------------
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * -------------------------------------------------------------------------------------------------------
 * 解题思路：
 * 从矩阵的右上角开始进行比较，如果右上角的值大于target，那么证明target不可能在该列，排除掉这一列
 * 如果小于target，那么证明target不可能在该行，排除掉这一行
 * 终止条件：row <= rows && column >= 0
 */
public class TwoDimArrayFind {

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length - 1, columns = array[0].length - 1;
        int row = 0, column = columns;
        while (row <= rows && column >= 0) {
            int cur = array[row][column];
            if (target == cur) {
                return true;
            } else if (target > cur) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
