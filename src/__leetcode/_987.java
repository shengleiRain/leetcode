package __leetcode;

import structure.tree.BinaryTree;
import structure.tree.TreeNode;

import java.util.*;

/**
 * @author Rain
 * @date 2019/9/15.
 */
public class _987 {

    public static void main(String[] args) {
        TreeNode root = new BinaryTree().buildBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new _987().verticalTraversal(root));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            List<Pair> list = map.getOrDefault(pair.x, new ArrayList<>());
            list.add(pair);
            map.put(pair.x, list);
            min = Math.min(min, pair.x);
            max = Math.max(max, pair.x);

            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.x - 1, pair.y + 1));
            }

            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.x + 1, pair.y + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            List<Pair> pairs = map.get(i);
            Collections.sort(pairs, (p1, p2) -> {
                if (p1.y == p2.y) {
                    return p1.node.val - p2.node.val;
                }
                return p1.y - p2.y;
            });
            List<Integer> list = new ArrayList<>();
            for (Pair pair : pairs) {
                list.add(pair.node.val);
            }
            res.add(list);
        }
        return res;


    }
}

class Pair {
    TreeNode node;
    int x;
    int y;

    public Pair(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
