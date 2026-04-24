package loopings;

import java.util.Scanner;

public class matrixSample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // user inputs - matrix dimension
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Enter element for [%d][%d]: ", i, j);
                matrix[i][j] = input.nextInt();
            }
        }

        int total = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("[%d] ", matrix[i][j]);
                total += matrix[i][j];
            }
            System.out.println();
        }

        System.out.println("Total sum of all elements: " + total);
    }
}
