package StringProblems;

public class ReverseStringUsingRecursion {
    private static String reverse = "";

    public static void main(String[] args) {
        System.out.println(reverseString("1 234 56 7 8 9"));
    }

    public static String reverseString(String text) {
        if (text.length() == 0) {
            return null;
        }
        if (text.length() == 1) {
            return text;
        } else {
            reverse += text.charAt(text.length() - 1)
                    + reverseString(text.substring(0, text.length() - 1));
        }


        return reverse;
    }
}
