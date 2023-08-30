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
    private static boolean isValid(String input) {
        char[] characters = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char character: characters) {
            if (character == '[' || character == '{' || character == '(') {
                stack.push(character);
            } else if (character == ']' && stack.pop() != '[') {
                return false;
            } else if (character == '}' && stack.pop() != '{') {
                return false;
            } else if (character == ')' && stack.pop() != '(') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]{}()"));
    }
}
