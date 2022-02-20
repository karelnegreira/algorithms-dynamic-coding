package StringProblems;

public class CheckIfTwoStringsAreAnagramsVersion2 {
    public static void main(String[] args) {
        System.out.println(isAnagram("stop", "pots2"));
    }

    public static boolean isAnagram(String text, String anagram) {
        if (text.length() != anagram.length()){
            return false;
        }
        char[] array = text.toCharArray();

        for (char c: array) {
            int index = anagram.indexOf(c);
            if(index != -1) {
                anagram = anagram.substring(0, index)
                        + anagram.substring(index + 1, anagram.length());
            } else {
                return false;
            }
        }
        return anagram.isEmpty();
    }
}
