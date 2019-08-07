import java.util.Scanner;

/**
 * @author Rain
 * @date 2019/8/4.
 */
public class Daji2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int bugNum = scanner.nextInt();
            int buff = scanner.nextInt();
            int coffeeNum = scanner.nextInt();
            int[] bugs = new int[bugNum];
            for (int i = 0; i < bugNum; i++) {
                bugs[i] = scanner.nextInt();
            }

            System.out.println(solveBugs(bugNum, buff, coffeeNum, bugs));

        }
    }

    private static int solveBugs(int bugNum, int buff, int coffeeNum, int[] bugs) {
        // 正常修改bug的时长
        int bugTotalTime = 0;
        for (int bug : bugs) {
            bugTotalTime += bug;
        }
        // 加速工作的时长
        int buffTotalTime = coffeeNum * 60 * buff;
        int competeTime = 0;
        if (buffTotalTime >= bugTotalTime) {
            competeTime = (int) Math.ceil((double) bugTotalTime / buff);
        } else {
            competeTime = (bugTotalTime - buffTotalTime) + buffTotalTime / buff;
        }

        return competeTime > 8 * 60 ? 0 : competeTime;
    }
}
