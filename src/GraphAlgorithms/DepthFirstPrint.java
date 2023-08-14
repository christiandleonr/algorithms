package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class DepthFirstPrint {
    private static void depthFirstPrint(Map<Character, List<Character>> graph, char source) {
        Stack<Character> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            char current = stack.pop();
            System.out.println(current);

            for (char c : graph.get(current)) {
                stack.push(c);
            }
        }
    }

    /**
     * Here there is not any base case using an if statement, but we can take a base case as a case where the recursive
     * call is no longer executed. Since at some point in the graph the array of source's neighbors is going to be empty
     * we can take that as a base case, the recursive call will no longer be executed and the propagation will start.
     *
     * @param graph
     * @param source
     */
    private static void depthFirstPrintRecursive(Map<Character, List<Character>> graph, char source) {
        System.out.println(source);

        for (char c : graph.get(source)) {
            depthFirstPrintRecursive(graph, c);
        }
    }

    public static void main(String[] args) throws IOException {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>() {{
            put('a', Arrays.asList('b', 'c'));
            put('b', List.of('d'));
            put('c', List.of('e'));
            put('d', List.of('f'));
            put('e', new ArrayList<>());
            put('f', new ArrayList<>());
        }};

        depthFirstPrint(graph, 'a');
        System.out.println("================================");
        depthFirstPrintRecursive(graph, 'a');
    }
}
