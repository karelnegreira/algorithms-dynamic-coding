package NumericProblems;

import java.util.Scanner;

public class MultiplyTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int col = 0;

        System.out.println("Kindly introdue the row of the matriz: ");
        row = scanner.nextInt();

        System.out.println("Kindly introdue the col of the matriz: ");
        col = scanner.nextInt();

        int[][] m1 = fillMatriz(row, col);

        System.out.println("Kindly introdue the row of the matriz: ");
        row = scanner.nextInt();

        System.out.println("Kindly introdue the col of the matriz: ");
        col = scanner.nextInt();

        int[][] m2 = fillMatriz(row, col);

        int[][] totalM = multiply(m1, m2);

        printMatriz(totalM);
    }

    public static int[][] fillMatriz(int row, int col) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    public static int[][] multiply(int[][] m1, int[][] m2) {
        int mul = m1[0][0]*m2[0][0];
        int[][] multiplicativeM = new int[m1.length][m2[0].length];
        int i = 0;
        int j = 0;

        for ( i = 0; i < m1.length; i ++) {
            for ( j = 0; j < m2[0].length; j++) {
                mul = mul +  (m1[i][j]*m2[j][i]);
            }
            multiplicativeM[i][j] = mul;
        }
        return multiplicativeM;
    }

    public static void printMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%s ", m[i][j]);
            }
            System.out.println();
        }
    }
}
