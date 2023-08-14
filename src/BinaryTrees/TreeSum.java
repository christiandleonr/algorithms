package BinaryTrees;

import Shared.Node;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {
    private static int depthFirstTreeSum(Node current) {
        if (current == null) {
            return 0;
        }

        return (Integer) current.getValue() + depthFirstTreeSum(current.getLeft()) + depthFirstTreeSum(current.getRight());
    }

    private static int breadthFirstTreeSum(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            sum += (Integer) current.getValue();

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }

        return sum;
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

        int result = depthFirstTreeSum(nodeA);
        System.out.println(result);

        result = breadthFirstTreeSum(nodeA);
        System.out.println(result);
    }
}
