package BinaryTrees;

import Shared.Node;

import java.io.IOException;

public class MaxPathSum {
    private static int maxPathSum(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return (Integer) root.getValue();
        }

        int maxValue = Math.max(maxPathSum(root.getLeft()), maxPathSum(root.getRight()));

        return (Integer) root.getValue() + maxValue;
    }

    /**
     *                 3
     *              /     \
     *             11      4
     *           /   \   /  \
     *          4    2 null  1
     */
    public static void main(String[] args) throws IOException {
        Node nodeA = new Node(3);
        Node nodeB = new Node(11);
        Node nodeC = new Node(4);
        Node nodeD = new Node(4);
        Node nodeE = new Node(2);
        Node nodeF = new Node(1);

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setRight(nodeF);

        int result = maxPathSum(nodeA);
        System.out.println(result);
    }
}
