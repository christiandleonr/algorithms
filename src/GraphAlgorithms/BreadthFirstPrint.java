package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class BreadthFirstPrint {
    private static void breadthFirstPrint(Map<Character, List<Character>> graph, char source) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.println(current);

            queue.addAll(graph.get(current));
        }
    }

    public static void main(String[] args) throws IOException {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>() {{
            put('a', Arrays.asList('c', 'b'));
            put('b', List.of('d'));
            put('c', List.of('e'));
            put('d', List.of('f'));
            put('e', new ArrayList<>());
            put('f', new ArrayList<>());
        }};

        breadthFirstPrint(graph, 'a');
    }
}
