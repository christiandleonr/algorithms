package BinaryTrees;

import Shared.Node;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMinValue {
    private static int depthFirstTreeMinValue(Node current) {
        if (current == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min((Integer) current.getValue(), Math.min(depthFirstTreeMinValue(current.getLeft()), depthFirstTreeMinValue(current.getRight())));
    }

    private static int breadthFirstTreeMinValue(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int minValue = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (minValue > (Integer) current.getValue()) {
                minValue = (Integer) current.getValue();
            }

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }

        return minValue;
    }

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

        int result = depthFirstTreeMinValue(nodeA);
        System.out.println(result);

        result = breadthFirstTreeMinValue(nodeA);
        System.out.println(result);
    }
}
