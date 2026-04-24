package StringChar;

import java.util.Arrays;
import java.util.Scanner;

public class anagramChecker {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter word 1: ");
        String word1 = scan.nextLine().toLowerCase();

        System.out.print("Enter word 2: ");
        String word2 = scan.nextLine().toLowerCase();

        boolean isAnagram = false;

        if (word1.length() == word2.length()) {
            char[] word1ToChar = word1.toCharArray();
            char[] word2ToChar = word2.toCharArray();

            Arrays.sort(word1ToChar);
            Arrays.sort(word2ToChar);

            if (Arrays.equals(word1ToChar, word2ToChar)) {
                isAnagram = true;
            }
        }

        System.out.println("Both words are anagram: " + isAnagram);
    }
}
