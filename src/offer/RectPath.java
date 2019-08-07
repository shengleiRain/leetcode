package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rain
 * @date 2019/8/7.
 * <p>
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class RectPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);
        char first = str[0];

        List<Integer> startIndexes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == first) {
                startIndexes.add(i);
            }
        }
        if (startIndexes.size() == 0) {
            return false;
        }

        boolean res = false;
        for (int startIndex : startIndexes) {
            res = res || hasPath(matrix, rows, cols, str, startIndex, visited, 0);
        }
        return res;

    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, int startIndex, boolean[] visited, int strIndex) {
        if (strIndex == str.length - 1 && matrix[startIndex] == str[strIndex]) {
            return true;
        }
        if (matrix[startIndex] != str[strIndex]) {
            return false;
        }
        visited[startIndex] = true;
        boolean res = false;
        //上
        if (startIndex - cols >= 0 && !visited[startIndex - cols]) {
            res = hasPath(matrix, rows, cols, str, startIndex - cols, visited, strIndex + 1);
        }
        //下
        if (startIndex + cols < matrix.length && !visited[startIndex + cols]) {
            res = res || hasPath(matrix, rows, cols, str, startIndex + cols, visited, strIndex + 1);
        }
        //左
        if (startIndex % cols > 0 && !visited[startIndex - 1]) {
            res = res || hasPath(matrix, rows, cols, str, startIndex - 1, visited, strIndex + 1);
        }
        //右
        if (startIndex % cols < cols - 1 && !visited[startIndex + 1]) {
            res = res || hasPath(matrix, rows, cols, str, startIndex + 1, visited, strIndex + 1);
        }
        visited[startIndex] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RectPath().hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4, "AAAAAAAAAAAA".toCharArray()));
    }
}
