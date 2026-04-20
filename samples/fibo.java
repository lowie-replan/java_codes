package samples;

public class fibo {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 0;
        System.out.println("This code prints first 10 fibonacci numbers\n");

        for (int i = 0; i < 2; i++) {
            System.out.print(a + " => ");
        }

        int count = 0;

        while (count != 10) {

            c = a + b;
            b = a;
            a = c;

            System.out.print(" => " + c);
            count++;
        }
    }
}
