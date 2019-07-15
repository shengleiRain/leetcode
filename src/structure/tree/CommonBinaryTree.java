package structure.tree;

/**
 * @author Rain
 * @date 2019/7/14.
 */
public class CommonBinaryTree implements Tree {

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


    }

    @Override
    public void removeNode(int value) {

    }

    @Override
    public TreeNode findNode(int value) {
        return null;
    }
}
