package NumericProblems;

import java.util.Scanner;

public class SumOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int col = 0;

        System.out.println("Which is the grade of the matrices to sum");
        row = scanner.nextInt();
        col = row;

        int[][] finalsummatory = summatoryOfTwoMatrices(row, col);

        printSum(finalsummatory, row, col);
    }

    private static void printSum(int[][] finalsummatory, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%s", finalsummatory[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] summatoryOfTwoMatrices(int row, int col) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz1 = new int[row][col];
        int[][] matriz2 = new int[row][col];
        int[][] matrizsummatory = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the value to fill in: ");
                matriz1[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the value to fill in: ");
                matriz2[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrizsummatory[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizsummatory;
    }
}
