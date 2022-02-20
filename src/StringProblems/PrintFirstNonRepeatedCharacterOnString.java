package StringProblems;

import java.util.*;

public class PrintFirstNonRepeatedCharacterOnString {
    public static void main(String[] args) {
        System.out.print(printFirstNonRepeatedString("kkarel"));
        System.out.print(printFirstNonRepeatedCharacterVersion2("Anabel Amazing"));
    }

    public static char printFirstNonRepeatedString(String text) {
        Map<Character, Integer> charactersFreq = new LinkedHashMap<>();
        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (charactersFreq.containsKey(c)) {
                charactersFreq.put(c, charactersFreq.get(c) + 1);
            } else {
                charactersFreq.put(c, 1);
            }
        }

        /**charactersFreq
                .entrySet()
                .stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1)
                .forEach(System.out::println);*/

        return charactersFreq
                .entrySet()
                .stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1)
                .findFirst().get().getKey();
    }

    public static char printFirstNonRepeatedCharacterVersion2(String text) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            } if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

}
