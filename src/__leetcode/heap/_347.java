package __leetcode.heap;

import java.util.*;

/**
 * @author Rain
 * @date 2019/7/10.
 */
public class _347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get).reversed());
        queue.addAll(map.keySet());
        List<Integer> topK = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            topK.add(queue.poll());
        }
        return topK;

    }


    public static void main(String[] args) {


//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(4);
//        queue.add(3);
//        queue.add(6);
//        queue.add(7);
//        queue.add(8);
//        queue.add(9);
//        queue.add(10);
//        queue.add(11);
//        System.out.println(queue.poll());


        System.out.println(new _347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
