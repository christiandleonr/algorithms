package Microsoft;

import Shared.Node;

import java.io.IOException;

public class SymmetricTree {
    private static boolean areSymmetric(Node left, Node right) {
        boolean leftIsNull = left == null;
        boolean rightIsNull = right == null;

        if (leftIsNull && rightIsNull) {
            return true;
        }

        if ((leftIsNull != rightIsNull) || (left.getValue() != right.getValue())) {
            return false;
        }

       return areSymmetric(left.getLeft(), right.getRight()) && areSymmetric(left.getRight(), right.getLeft());
    }

    private static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return areSymmetric(root.getLeft(), root.getRight());
    }

    public static void main(String[] args) throws IOException {
        Node root = new Node(10);

        Node nodeA = new Node(5);
        Node nodeA2 = new Node(5);

        Node nodeB = new Node(8);
        Node nodeB2 = new Node(8);

        Node nodeC = new Node(2);
        Node nodeC2 = new Node(2);

        Node nodeD = new Node(9);
        Node nodeD2 = new Node(9);

        Node nodeE = new Node(7);
        Node nodeE2 = new Node(7);

        Node nodeF = new Node(1);
        Node nodeF2 = new Node(1);

        Node nodeG = new Node(3);
        Node nodeG2 = new Node(3);

        Node nodeH = new Node(0);
        Node nodeH2 = new Node(0);

        Node nodeI = new Node(6);
        Node nodeI2 = new Node(6);

        // Set root node
        root.setLeft(nodeA);
        root.setRight(nodeA2);

        // Build left side of the binary tree

        nodeA.setLeft(nodeC);
        nodeA.setRight(nodeB);

        nodeB.setLeft(nodeF);

        nodeC.setLeft(nodeD);
        nodeC.setRight(nodeE);

        nodeD.setLeft(nodeG);
        nodeD.setRight(nodeH);

        nodeE.setRight(nodeI);

        // Build right side of the binary tree

        nodeA2.setRight(nodeC2);
        nodeA2.setLeft(nodeB2);

        nodeB2.setRight(nodeF2);

        nodeC2.setRight(nodeD2);
        nodeC2.setLeft(nodeE2);

        nodeD2.setRight(nodeG2);
        nodeD2.setLeft(nodeH2);

        nodeE2.setLeft(nodeI2);

        System.out.println(isSymmetric(root));
    }
}
