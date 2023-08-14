package BinaryTrees;

import Shared.Node;

import java.io.IOException;
import java.util.*;

public class BinaryTreePrint {

    private static void depthFirstPrint(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.getValue());

            if (current.getRight() != null) stack.push(current.getRight());
            if (current.getLeft() != null) stack.push(current.getLeft());
        }
    }

    private static void depthFirstPrintRecursive(Node source) {
        if (source == null) {
            return;
        }
        System.out.println(source.getValue());

        if (source.getLeft() != null) {
            depthFirstPrintRecursive(source.getLeft());
        }

        if (source.getRight() != null) {
            depthFirstPrintRecursive(source.getRight());
        }
    }

    private static void breadthFirstPrint(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.getValue());

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
    }

    public static void main(String[] args) throws IOException {
        Node nodeA = new Node('a');
        Node nodeB = new Node('b');
        Node nodeC = new Node('c');
        Node nodeD = new Node('d');
        Node nodeE = new Node('e');
        Node nodeF = new Node('f');

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setRight(nodeF);

        depthFirstPrint(nodeA);
        System.out.println("=======================================");
        depthFirstPrintRecursive(nodeA);
        System.out.println("=======================================");
        breadthFirstPrint(nodeA);
    }

}
