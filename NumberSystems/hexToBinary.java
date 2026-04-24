package NumberSystems;

import java.util.Scanner;

public class hexToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Hex value: ");
        String hex = scan.nextLine();
        System.out.println(hexToDec(hex));
    }

    public static int hexToDec(String hex) {
        String values = "0123456789ABCDEF";
        int decimal = 0;
        int power = 0;

        for (int i = hex.length() - 1; i >= 0; i--){
            decimal += (int) (values.indexOf(hex.charAt(i)) * Math.pow(16, power));
            power++;
        }
        return decimal;
    }
}
