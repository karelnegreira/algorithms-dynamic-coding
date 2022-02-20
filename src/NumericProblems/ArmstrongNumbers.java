package NumericProblems;

public class ArmstrongNumbers {

    private static int digitsCounter = 0;
    private static int[] digits;

    public static void main(String[] args) {
        System.out.println(isArmstrong(4070));
    }

    public static boolean isArmstrong(int number) {
        int numberOfDigits = getNumberOfDigits(number);
        int[] digits2 = digits;
        int armstrongSummatory = 0;

        for (int i = 0; i < digits2.length; i++) {
            armstrongSummatory += Math.pow(digits2[i], numberOfDigits);
        }

        if (armstrongSummatory == number) {
            return true;
        }

        return false;
    }

    public static int getNumberOfDigits(int number) {
        int temp = number;

        while (temp > 0) {
            temp = temp / 10;
            digitsCounter++;
        }

        digits = new int[digitsCounter];
        char[] charsDigits = String.valueOf(number).toCharArray();

        for (char x: charsDigits) {
            System.out.println(x);
        }

        for (int i = 0; i < digitsCounter; i++) {
            digits[i] = Character.getNumericValue(charsDigits[i]);
            System.out.println(digits[i]);
        }
        return digitsCounter;
    }

}
