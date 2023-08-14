package CommonCodingProblems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Two words are anagram if they are made of the same characters with the same frequencies.
 */
public class ValidAnagram {

    /**
     * Using Hashmaps to count the number of times that a character appears in the words,
     * in order to get a valid anagram, both hashmaps must have the same characters and the same
     * occurrence for each character.
     *
     * @param wordOne
     * @param wordTwo
     * @return
     */
    private static boolean validAnagram(String wordOne, String wordTwo) {
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }

        Map<Character, Integer> charactersWordOne = new HashMap<>();
        Map<Character, Integer> charactersWordTwo = new HashMap<>();

        for (char character : wordOne.toCharArray()) {
            if (charactersWordOne.containsKey(character)) {
                charactersWordOne.put(character, charactersWordOne.get(character) + 1);
            } else {
                charactersWordOne.put(character, 1);
            }
        }

        for (char character : wordTwo.toCharArray()) {
            if (charactersWordTwo.containsKey(character)) {
                charactersWordTwo.put(character, charactersWordTwo.get(character) + 1);
            } else {
                charactersWordTwo.put(character, 1);
            }
        }

        System.out.println(charactersWordOne);
        System.out.println(charactersWordTwo);

        for (char character: charactersWordOne.keySet()) {
            if (!charactersWordTwo.containsKey(character)
                    || !Objects.equals(charactersWordOne.get(character), charactersWordTwo.get(character))) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method follows the approach of getting a list of characters from each word and sorting both lists,
     * to have a valid anagram both sorted lists must look exactly the same and have the same order.
     *
     * @param wordOne
     * @param wordTwo
     * @return
     */
    private static boolean validAnagramSort(String wordOne, String wordTwo) {
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }

        List<Character> charactersWordOne = wordOne.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        List<Character> charactersWordTwo = wordTwo.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Collections.sort(charactersWordOne);
        Collections.sort(charactersWordTwo);

        System.out.println(charactersWordOne);
        System.out.println(charactersWordTwo);

        return Objects.equals(charactersWordOne, charactersWordTwo);
    }

    public static void main(String[] args) {
        boolean result = validAnagram("nameless", "salesmen");
        System.out.println(result);

        result = validAnagramSort("nameless", "salesmen");
        System.out.println(result);
    }
}
