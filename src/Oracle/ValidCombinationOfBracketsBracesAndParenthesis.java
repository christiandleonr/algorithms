package Oracle;

import java.util.Stack;

public class ValidCombinationOfBracketsBracesAndParenthesis {
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
