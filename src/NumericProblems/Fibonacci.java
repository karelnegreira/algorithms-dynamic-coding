package NumericProblems;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciV2(9));
    }

    public static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static int fibonacciV2(int number) {
        int[] fib = new int[number + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= number; i ++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[number];
    }
}
