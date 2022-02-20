package NumericProblems;

import java.util.Scanner;

public class MatrizTransposition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int col = 0;

        System.out.println("Enter the row/col of the matriz");
        row = scanner.nextInt();
        col = scanner.nextInt();

        int[][] matriz1 = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the value to fill in: ");
                matriz1[i][j] = scanner.nextInt();
            }
        }

        printMatriz(matriz1, row, col);
        int[][] trans = transpose(matriz1, row, col);
        printMatriz(trans, col, row);
    }

    public static int[][] transpose(int[][] matriz, int row, int col) {
        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matriz[i][j];
                System.out.println(transpose[j][i]);
            }
            System.out.println();
        }

        return transpose;
    }

    static void printMatriz(int[][] matriz, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf( "%s ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
