package __leetcode.build_tree;

import structure.tree.CommonBinaryTree;
import structure.tree.Tree;
import structure.tree.TreeNode;

import java.util.HashMap;

/**
 * @author Rain
 * @date 2019/7/14.
 */
public class _437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSum(root, 0, sum, map);

//        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val)
                + pathSumFrom(root.right, sum - root.val);
    }

    public int pathSum(TreeNode root, int curSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += pathSum(root.left, curSum, sum, map) + pathSum(root.right, curSum, sum, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }


    public static void main(String[] args) {
        Tree tree = new CommonBinaryTree();
        TreeNode root = tree.buildBinaryTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(new _437().pathSum(root, 8));
    }
}
