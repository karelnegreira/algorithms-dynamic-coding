package StringProblems;

public class FIndAllPermutationsInString {

    public static void main(String[] args) {
        findPermutation("","karel");
    }

    public static void findPermutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                findPermutation(perm + word.charAt(i), word.substring(0, i) +
                        word.substring(i + 1));
            }
        }
    }

}
