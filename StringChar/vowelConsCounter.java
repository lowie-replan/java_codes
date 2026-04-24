package StringChar;

import java.util.Scanner;

public class vowelConsCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String: ");
        String input = scan.nextLine().toLowerCase();

        String vowels = "aeiou";
        int vowelCounter = 0;
        int consonantCounter = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) != -1) {
                    vowelCounter++;
                }
                else {
                    consonantCounter++;
                }
            }
        }
        System.out.printf("Vowels: %d \nConsonants: %d", vowelCounter, consonantCounter);
    }
}
