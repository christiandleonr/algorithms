package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class MinimumIsland {
    private static int minimumIsland(List<List<Character>> grid) {
        Set<String> visited = new HashSet<>();
        int minimumIsland = 99999;

        for (int r=0; r<grid.size(); r++) {
            for (int c=0; c<grid.get(0).size(); c++) {
                int result = depthFirstExplore(grid, r, c, visited);
                if (result != 0) {
                    minimumIsland = Math.min(minimumIsland, result);
                }
            }
        }

        return minimumIsland;
    }

    private static int depthFirstExplore(List<List<Character>> grid, int r, int c, Set<String> visited) {
        boolean rowInbound = r >= 0 && r < grid.size();
        boolean colInbound = c >= 0 && c < grid.get(0).size();

        if (!rowInbound || !colInbound) {
            return 0;
        }

        if (grid.get(r).get(c) == 'W') {
            return 0;
        }

        String node = r + "," + c;
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);

        int size = 1;
        size += depthFirstExplore(grid, r - 1, c, visited);
        size += depthFirstExplore(grid, r + 1, c, visited);
        size += depthFirstExplore(grid, r, c - 1, visited);
        size += depthFirstExplore(grid, r, c + 1, visited);

        return size;
    }

    public static void main(String[] args) throws IOException {
        List<List<Character>> grid = new ArrayList<>() {{
            add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
            add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
            add(Arrays.asList('W', 'L', 'W', 'L', 'W'));
            add(Arrays.asList('W', 'W', 'L', 'L', 'W'));
            add(Arrays.asList('L', 'W', 'W', 'L', 'L'));
            add(Arrays.asList('L', 'L', 'W', 'W', 'W'));
        }};

        int result = minimumIsland(grid);
        System.out.println(result);
    }
}
