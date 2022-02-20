package codingtest;

import java.util.*;

/**
 * Given an input string and a dictionary of words,
 * find out if the input string can be segmented into a
 * space-separated sequence of dictionary words
 * */
public class WordBreakProblem {
    private static Set<String> dictionary = new LinkedHashSet<>();

    public static void main(String[] args) {
        String[] temp_dictionary = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        for (String temp: temp_dictionary) {
            dictionary.add(temp);
        }
        //tests
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("jghdkjfgjdhfkjghdkjfg"));
        System.out.println(wordBreak("ilikelikeimangoiii"));
    }
    //check if the work can be splitted in parts
    //such as are contained in the dictionary
    public static boolean wordBreak(String word) {
        int size = word.length();

        if (size == 0) {
            return true;
        }
        for (int i = 1; i <= size; i++) {
            if (dictionary.contains(word.substring(0, i)) && wordBreak(word.substring(i, size))) {
                System.out.print(word.substring(0, i) + " ");
                return true;
            }
        }
        //if all cases failed then return false
        return false;
    }
}
