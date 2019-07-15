package structure.tree;

import java.util.*;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public interface Tree {

    /**
     * 新增节点
     *
     * @param value
     */
    void addNode(int value);

    /**
     * 删除节点
     *
     * @param value
     */
    void removeNode(int value);

    TreeNode findNode(int value);

    default TreeNode buildBinaryTree(Integer[] values) {
        List<TreeNode> nodeList = new ArrayList<>(values.length);
        for (Integer value : values) {
            nodeList.add(value == null ? null : new TreeNode(value));
        }
        for (int i = 0; i < nodeList.size() / 2 - 1; i++) {
            TreeNode node = nodeList.get(i);
            if (node != null) {
                node.left = nodeList.get(2 * i + 1);
                node.right = nodeList.get(2 * i + 2);
            }
        }
        int lastPNodeIndex = nodeList.size() / 2 - 1;
        TreeNode lastPNode = nodeList.get(lastPNodeIndex);
        if (lastPNode != null) {
            lastPNode.left = nodeList.get(2 * lastPNodeIndex + 1);
            if (nodeList.size() % 2 == 1) {
                lastPNode.right = nodeList.get(2 * lastPNodeIndex + 2);
            }
        }

        return nodeList.get(0);


    }

    /**
     * 前序遍历
     *
     * @param root
     */
    default void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    /**
     * 前序遍历，非递归方式
     *
     * @param root
     * @return
     */
    default List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();//用来存访问的节点
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

        }

        return result;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    default void middleOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrderTraverse(root.left);
        System.out.print(root.val + " ");
        middleOrderTraverse(root.right);
    }

    /**
     * 中序遍历，非递归方式
     *
     * @param root
     * @return
     */
    default List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //先将所有的所节点依次入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            // 看该节点有没有右节点
            cur = cur.right;
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    default void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 后序遍历，非递归方式
     */
    default List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {

        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 层序遍历
     */
    default void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 借助队列的先进先出的特性，只要队列中有节点，那就poll出第一个节点，然后将其左右节点入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 求一棵树的高度
     */
    default int treeHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    /**
     * 求一棵树的高度，非递归方法
     */
    default int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0, cur = 1, next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }

            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                depth++;
                cur = next;
                next = 0;
            }
        }
        return depth;
    }
}
