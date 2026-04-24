package StringChar;

import java.util.Scanner;

public class stringRotationCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String input1 = scan.nextLine().toLowerCase();
        System.out.print("Enter String 2: ");
        String input2 = scan.nextLine().toLowerCase();

        String merged = input1 + input1;

        boolean isRotation = merged.contains(input2);

        System.out.println(isRotation);
    }
}
