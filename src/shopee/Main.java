package shopee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rain
 * @date 2019/8/10.
 */
public class Main {

    private static HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 会议室的数量
        int roomCount = scanner.nextInt();
        while (scanner.hasNext()) {
            // 请求编号
            int request = scanner.nextInt();
            if (request == 1) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                int roomNum = scanner.nextInt();
                System.out.println(request(roomNum, startTime, endTime));
            } else if (request == 2) {
                int searchTime = scanner.nextInt();
                int roomNum = scanner.nextInt();
                System.out.println(search(roomNum, searchTime));
            }
        }
    }

    private static int request(int roomNum, int startTime, int endTime) {
        List<List<Integer>> time = map.getOrDefault(roomNum, new ArrayList<>());
        int flag = 1;
        if (map.containsKey(roomNum)) {
            for (List<Integer> aTime : time) {
                if (search(roomNum, startTime) == 0 || search(roomNum, endTime) == 0) {
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 1) {
            List<Integer> item = new ArrayList<>(2);
            item.add(startTime);
            item.add(endTime);
            time.add(item);
        }
        map.put(roomNum, time);
        return flag;


    }

    private static int computeInterval(int startTime, int endTime) {
        if (startTime <= endTime) {
            return endTime - startTime;
        } else {
            return 24 + endTime - startTime;
        }
    }

    private static int search(int roomNum, int searchTime) {
        int flag = 1;
        if (map.containsKey(roomNum)) {
            List<List<Integer>> time = map.get(roomNum);
            for (List<Integer> aTime : time) {
                int startTime = aTime.get(0);
                int endTime = aTime.get(1);
                if (startTime <= endTime) {
                    if (searchTime >= startTime && searchTime <= endTime) {
                        flag = 0;
                    }
                } else {
                    if (searchTime >= startTime && searchTime <= endTime + 24) {
                        flag = 0;
                    }
                }
                if (flag == 0) {
                    break;
                }
            }

        }
        return flag;
    }
}
