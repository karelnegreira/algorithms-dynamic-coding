package StringProblems;

public class CheckIfAWordIsPalindrome {

    private static String reversed = "";

    public static void main(String[] args) {
        System.out.println(isPalindrome("Able was I ere I saw Elba"));
        System.out.println(isPalindrome("A man, a plan, a canal – Panama"));
    }

    public static boolean isPalindrome(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "");
        String reversedText = reverse(cleanText);

        if (reversedText.equalsIgnoreCase(cleanText)) {
            return true;
        }
        return false;
    }

    private static String reverse(String text) {
        if (text.length() == 0) {
            return null;
        } if (text.length() == 1) {
            return text;
        } else {
            return  text.charAt(text.length() - 1)
                    + reverse(text.substring(0, text.length() - 1));
        }
    }

}
