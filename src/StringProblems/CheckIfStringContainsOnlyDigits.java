package StringProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIfStringContainsOnlyDigits {
    public static void main(String[] args) {
        System.out.println(checkOnlyDIgits("5654566582224157"));
    }

    public static boolean checkOnlyDIgits(String text) {
        String pattern = "[0-9]+";
        Pattern pattern1 = Pattern.compile(pattern);

        Matcher matches = pattern1.matcher(text);
        return matches.matches();
    }

}
