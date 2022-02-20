package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharacterOnString {
    public static void main(String[] args) {
        printDups("Karkassakkk");
    }

    public static void printDups(String text) {
        char[] array = text.toCharArray();
        Map<Character, Integer> charsFreq = new HashMap<>();

        for (char character: array) {
            if (charsFreq.containsKey(character)) {
                charsFreq.put(character, charsFreq.get(character) + 1);
            } else {
                charsFreq.put(character, 1);
            }
        }
/*
        for (Map.Entry<Character, Integer> entrySet: charsFreq.entrySet()) {
            if (entrySet.getValue() > 1) {
                System.out.printf("%s : %d %n", entrySet.getKey(), entrySet.getValue());
            }
        }*/
        charsFreq.entrySet()
                .stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue() > 1)
                .forEach(System.out::println);



    }
}
