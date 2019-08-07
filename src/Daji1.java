import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rain
 * @date 2019/8/4.
 */
public class Daji1 {

    // 价格，零食的满意度,零食的数量
    private static int satisfy(List<List<Integer>> goods, int money, int lines) {
        goods.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                float one = (float) o1.get(0) / o1.get(1);
                float two = (float) o2.get(0) / o2.get(1);
                if (one < two) {
                    return -1;
                } else if (one == two) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        int totalSat = 0;
        for (int i = 0; i < lines; i++) {
            List<Integer> good = goods.get(i);
            int num = Math.min(money / good.get(0), good.get(2));
            totalSat += num * good.get(1);
            money -= num * good.get(0);
        }
        return totalSat;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int lines = scanner.nextInt();
            int money = scanner.nextInt();
            List<List<Integer>> sells = new ArrayList<>(lines);
            for (int i = 0; i < lines; i++) {
                List<Integer> item = new ArrayList<>(3);
                item.add(scanner.nextInt());
                item.add(scanner.nextInt());
                item.add(scanner.nextInt());
                sells.add(item);
            }
            System.out.println(satisfy(sells, money, lines));
        }

    }
}
