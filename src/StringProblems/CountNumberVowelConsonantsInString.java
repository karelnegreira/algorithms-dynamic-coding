package StringProblems;

public class CountNumberVowelConsonantsInString {
    static int vowel = 0;
    static int consonant = 0;

    public static void main(String[] args) {
        check("karel");
        System.out.println("The total of vowels is: " + vowel + " and consonants: " + consonant);
    }

    public static void check(String text) {
        char[] charArray = text.toCharArray();
        for (char x: charArray) {
            isVowelOrConsonant(x);
        }
    }

    public static void isVowelOrConsonant(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            vowel++;
        } else {
            consonant++;
        }

    }
}
