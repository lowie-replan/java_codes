package NumberSystems;

import java.util.Scanner;

public class binaryToOctal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter binary value: ");
        String binary = scan.nextLine();
        System.out.println(binToOct(binary));
    }
    public static String binToOct(String binary) {
        StringBuilder octal = new StringBuilder();
        for (int i = binary.length(); i > 0; i -= 3) {
            int sum = 0;
            int multiplier = 1;
            for (int j = i - 1; j >= i - 3 && j >= 0; j--) {
                sum += multiplier;
                System.out.println(sum);
                multiplier *= 2;
            }
            octal.append(sum);
        }
        return octal.reverse().toString();
    }
}
