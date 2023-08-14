package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    /**
     * Dynamic Programming -> The key idea behind dynamic programming is to divide a complex problem into smaller,
     * simpler sub-problems and then solve these sub-problems independently. As the algorithm progresses, it stores
     * the solutions to sub-problems in memory so that it can quickly access them when needed, instead of recomputing
     * the solutions every time.
     * <p>
     * Memoization -> we basically save the data we already compute for a sub-problem and use it whenever the sub-problem
     * appears again.
     */
    private static long fib(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 2) return 1;

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(5, new HashMap<>()));
        System.out.println(fib(8, new HashMap<>()));
        System.out.println(fib(50, new HashMap<>()));
    }
}
