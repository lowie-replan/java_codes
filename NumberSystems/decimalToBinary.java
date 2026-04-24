package NumberSystems;

import java.util.Scanner;

public class decimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean error;
        do {
            try {
                error = false;
                System.out.print("Enter decimal value: ");
                int decimal = scan.nextInt();
                System.out.println(decToBinary(decimal));
            }
            catch (Exception e) {
                System.out.println("Incorrect input!");
                scan.nextLine();
                error = true;
            }
        } while (error);
    }

    public static String decToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.append(remainder);
            decimal = decimal / 2;
        }
        return String.valueOf(binary.reverse());
    }
}
