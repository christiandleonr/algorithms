package BinaryTrees;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class TreeIncludes {
    private static boolean depthFirstTreeIncludes(Node source, Node target) {
        if (source == null || target == null) {
            return false;
        }

        if (source.getValue() == target.getValue()) {
            return true;
        }

        return (depthFirstTreeIncludes(source.getLeft(), target) || depthFirstTreeIncludes(source.getRight(), target));
    }

    private static boolean breadthFirstTreeIncludes(Node source, Node target) {
        if (source == null || target == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getValue() == target.getValue()) {
                return true;
            }

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Node nodeA = new Node('a');
        Node nodeB = new Node('b');
        Node nodeC = new Node('c');
        Node nodeD = new Node('d');
        Node nodeE = new Node('e');
        Node nodeF = new Node('f');
        Node nodeG = new Node('g');

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setRight(nodeF);

        boolean result = depthFirstTreeIncludes(nodeA, nodeE);
        System.out.println(result);

        result = breadthFirstTreeIncludes(nodeA, nodeB);
        System.out.println(result);
    }
}
