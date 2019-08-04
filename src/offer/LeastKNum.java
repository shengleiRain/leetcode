package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class LeastKNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int value : input) {
            heap.add(value);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (k-- > 0) {
            result.add(heap.poll());
        }
        return result;
    }
}
