package StringChar;

import java.util.Scanner;

public class uniqueCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String: ");
        String input = scan.nextLine().toLowerCase();
        int index = -1;

        for (char c : input.toCharArray()) {
            if (input.indexOf(c) == input.lastIndexOf(c)) {
                index = input.indexOf(c);
                break;
            }
        }
        System.out.println(index);
    }
}
