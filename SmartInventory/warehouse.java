package SmartInventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

class Product {
    String id;
    String name;
    int quantity;
    double price;

    Product (String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class warehouse {
    public static void main(String[] args) {
        String inputData = "SmartInventory/reports.txt";

        ArrayList<Product> productList = new ArrayList<>();

        for (String[] s : readFile(inputData)) {
            productList.add(new Product(
                s[0],
                s[1],
                Integer.parseInt(s[2]),
                Double.parseDouble(s[3])
            ));
        }

        double total = 0;
        System.out.println("--- Current Inventory ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SmartInventory/report.txt"))){
        writer.write("======= WAREHOUSE RESTOCK REPORT =======\n");
        writer.write("ID NAME STOCK VALUE\n");
        writer.write("----------------------------------------------------\n");

        for (Product p : productList) {
            System.out.printf("ID: %s | %s | Stock: %d | Price: %.2f", p.id, p.name, p.quantity, p.price);
            System.out.println();
            total += p.price * p.quantity;
            if (p.quantity < 15) {
                p.price *= p.quantity;
                writer.write(p.id + " " + p.name + " " + p.quantity + " $" + p.price);
                writer.newLine();
            }
        }
        writer.write("----------------------------------------------------\n");
        writer.write("Total Global Inventory Value: $" + total);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String[]> readFile (String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            ArrayList<String[]> dataHolder = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                dataHolder.add(data);
            }
            return dataHolder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
