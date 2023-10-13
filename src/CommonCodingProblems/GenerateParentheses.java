package CommonCodingProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A combination that contains 1 type of parentheses is valid if every opening parenthesis
 * has its closing parenthesis, and it doesn't have a closing parenthesis without having an unused
 * opening parenthesis before it. Generate all possible combinations of parentheses given a number N that
 * indicates the number of parentheses.
 */
public class GenerateParentheses {

    private static void generate(int n, int diff, Stack<Character> comb, List<String> combs) {
        if (diff < 0 || diff > n) {
            return;
        } if (n == 0 && diff == 0) {
            combs.add(join(comb));
        } else {
            comb.add('(');
            generate(n-1, diff + 1, comb, combs);
            comb.pop();

            comb.add(')');
            generate(n-1, diff - 1, comb, combs);
            comb.pop();
        }
    }

    private static String join(Stack<Character> comb) {
        StringBuilder actualComb = new StringBuilder();

        for (Character character: comb) {
            actualComb.append(character);
        }

        return actualComb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combs = new ArrayList<>();

        generate(2*n, 0, new Stack<>(), combs);
        System.out.println(combs);
    }
}
