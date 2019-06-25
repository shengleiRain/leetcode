package backAlgo;

/**
 * Created by Rain on 2019/6/5.
 */
public class EightQueen {
    static int count=0;
    private static final int queenNums=20;
    // 下标表示行，值表示列
    private static int[] queenColumn = new int[queenNums];

    public static void calqueens(int row) {
        if (row == queenNums) {
            printQueen();
            count++;
            return;
        }
        for (int column = 0; column < queenNums; column++) {//每一行都有count种放法
            if (isOk(row, column)) {
                queenColumn[row] = column;
                calqueens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {// 逐行向上考虑
            if (queenColumn[i] == column) return false;//第i行的column列上有放置皇后
            if (leftUp >= 0 && queenColumn[i] == leftUp) {
                return false;
            }
            if (rightUp < queenNums && queenColumn[i] == rightUp) return false;
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private static void printQueen() {
        for (int row = 0; row < queenNums; ++row) {
            for (int column = 0; column < queenNums; ++column) {
                if (queenColumn[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        calqueens(0);
        System.out.println(count);
    }


}
