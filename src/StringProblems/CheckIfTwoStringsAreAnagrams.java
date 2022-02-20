package StringProblems;

public class CheckIfTwoStringsAreAnagrams {
    public static void main(String[] args) {
        checkAnagrams("stop", "pots");
    }

    public static void checkAnagrams(String text1, String text2) {
        StringBuffer buffer = new StringBuffer(text2);

        if (text1.equalsIgnoreCase(buffer.reverse().toString())) {
            System.out.println("It is an anagram");
        } else
            System.out.println("It is not an anagram");
    }
}
