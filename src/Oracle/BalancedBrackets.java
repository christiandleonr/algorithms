package Oracle;

import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *
 * Two brackets are considered to be a matched pair if the opening bracket (i.e., (, [, or {)
 * occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are
 * three types of matched pairs of brackets: [], {}, and ().
 */
public class BalancedBrackets {
    // ([]{}()) -> valid
    // ([)] -> invalid
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.add(bracket);
            } else {
                if (stack.isEmpty())
                    return false;

                char lastBracket = stack.pop();
                if (bracket == ')' && lastBracket != '(') {
                    return false;
                } else if (bracket == ']' && lastBracket != '[') {
                    return false;
                } else if (bracket == '}' && lastBracket != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[]{}()"));
    }
}
