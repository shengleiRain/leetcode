package structure.tree;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public class BinaryTree implements Tree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    @Override
    public void addNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode parent, t = root;
        do {
            parent = t;
            if (value <= t.val) {
                t = t.left;
            } else {
                t = t.right;
            }
        } while (t != null);
        TreeNode newNode = new TreeNode(value);
        if (value <= parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    @Override
    public void removeNode(int value) {
        TreeNode t = root, parent = null;
        // 遍历查找值等于value的节点
        while (t != null && t.val != value) {
            parent = t;
            if (t.val < value) {
                t = t.right;
            } else if (t.val > value) {
                t = t.left;
            }
        }

        // 没有找到
        if (t == null) {
            return;
        }

        // 1, 找到的节点有左孩子和右孩子，那么需要找到右子树中的最小值节点
        if (t.left != null && t.right != null) {
            TreeNode minRight = t.right, minRightParent = t;
            while (minRight.left != null) {
                minRightParent = minRight;
                minRight = minRight.left;
            }
            t.val = minRight.val;
            parent = minRightParent;
            t = minRight;
        }

        // 2, 当节点只有一个左孩子或右孩子，或者是叶子结点
        TreeNode child;
        if (t.left != null) {
            child = t.left;
        } else if (t.right != null) {
            child = t.right;
        } else {
            child = null;
        }

        // 被删除的节点是根节点
        if (parent == null) {
            root = child;
        } else if (parent.left == t) {
            parent.left = child;
        } else if (parent.right == t) {
            parent.right = child;
        }


    }

    @Override
    public TreeNode findNode(int value) {
        TreeNode t = root;
        while (t != null) {
            if (t.val < value) {
                t = t.right;
            } else if (t.val > value) {
                t = t.left;
            } else {
                return t;
            }
        }
        return null;
    }
}
