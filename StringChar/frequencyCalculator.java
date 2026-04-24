package StringChar;

import java.util.Scanner;

public class frequencyCalculator {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String: ");
        String input = scan.nextLine().toLowerCase();

        System.out.print("Enter the character: ");
        char charInput = scan.next().charAt(0);

        boolean characterFound = false;
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == charInput) {
                count++;
                characterFound = true;
            }
        }
        System.out.printf(!characterFound ? "Character not found!" : "There are %d letter/s \"%s\" in the string", count, charInput);
    }
}
