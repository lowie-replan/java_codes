package NumberSystems;

import java.util.Scanner;

public class binaryToHex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter binary value: ");
        int binary = scan.nextInt();
        System.out.println(binToHex(binary));
    }

    public static String binToHex (int binary) {
        String hexValues = "0123456789ABCDEF";
        StringBuilder hex = new StringBuilder();
        int sum = 0;
        int multiplier = 1;
        while (binary > 0) {
            int lastNum = binary % 10;
            sum += (lastNum * multiplier);
            if (multiplier == 8) {
                hex.append(hexValues.charAt(sum));
                multiplier = 1;
                sum = 0;
            }
            else multiplier *= 2;
            binary /= 10;
        }
        if (multiplier > 1) {
            hex.append(hexValues.charAt(sum));
        }
        return hex.reverse().toString();
    }
}
