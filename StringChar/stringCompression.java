package StringChar;

import java.util.ArrayList;
import java.util.Scanner;

public class stringCompression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String: ");
        String input = scan.nextLine().toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while ((i + 1) < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            if (count == 1) {
                System.out.print(input.charAt(i));
            }
            else System.out.print(input.charAt(i) + "" + count);

        }
    }
}
