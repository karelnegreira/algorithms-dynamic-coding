package StringProblems;

import java.util.StringTokenizer;

public class ReverseWordsInSentances {
    public static void main(String[] args) {
        reverseSentance("Karel, es un duro de matar");
    }

    public static void reverseSentance(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        String[] words = new String[tokenizer.countTokens()];
        int counter = 0;

        while (tokenizer.hasMoreTokens()) {
            words[counter] = tokenizer.nextToken();
            counter++;
        }

        for (int counter2 = words.length - 1; counter2 >= 0; counter2--) {
            System.out.print(words[counter2] + " ");
        }
    }
}
