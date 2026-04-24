package StringChar;

import java.util.ArrayList;
import java.util.Scanner;

public class countCharFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter String: ");
        String input = scan.nextLine().toLowerCase().replaceAll("\\s","");


        ArrayList <Character> chars = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int counter = 0;
            char temp = input.charAt(i);
            if (!chars.contains(input.charAt(i))) {
                for (char c : input.toCharArray()) {
                    if (temp == c) {
                        counter++;
                    }
                }
                System.out.println(input.charAt(i) + " = " + counter);
                chars.add(input.charAt(i));
            }
        }
    }
}
