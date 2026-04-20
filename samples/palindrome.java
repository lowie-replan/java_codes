package samples;

import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter Input: ");
            String input = scanner.nextLine();

            int left = 0;
            int right = input.length() - 1;
            boolean isPalindrome = true;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            if (isPalindrome) {
                System.out.println("Palindrome!");
            } else {
                System.out.println("Not A Palindrome!");
            }
        }
    }
}
