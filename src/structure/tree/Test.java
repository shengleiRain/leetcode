package structure.tree;

/**
 * @author Rain
 * @date 2019/7/3.
 */
public class Test {

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();
        tree.addNode(5);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(6);
        tree.addNode(4);
        tree.addNode(7);
        tree.addNode(10);
        tree.preOrderTraverse(tree.getRoot());
        System.out.println();
        tree.middleOrderTraverse(tree.getRoot());
        System.out.println();
        tree.postOrderTraverse(tree.getRoot());
        System.out.println();
        tree.levelOrderTraverse(tree.getRoot());
        System.out.println();

        tree.removeNode(6);
        tree.preOrderTraverse(tree.getRoot());
        System.out.println();
        tree.middleOrderTraverse(tree.getRoot());
        System.out.println();
        tree.postOrderTraverse(tree.getRoot());
        System.out.println();
        tree.levelOrderTraverse(tree.getRoot());
        System.out.println();


    }
}
