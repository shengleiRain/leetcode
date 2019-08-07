package offer;

import structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rain
 * @date 2019/8/6.
 * <p>
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                builder.append("#");
            } else {
                builder.append(poll.val);
                queue.add(poll.left);
                queue.add(poll.right);
            }
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.isEmpty()) {
            return null;
        }
        String[] strs = str.split(" ");
        TreeNode[] nodes = new TreeNode[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(strs[i]));

            }
        }
        TreeNode root = nodes[0];
        for (int i = 0, j = 1; j < nodes.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[j++];
                nodes[i].right = nodes[j++];
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SerializeTree().Deserialize("5 4 # 3 # 2");
        System.out.println();
    }
}
