package Application_Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CalculateStocks {
    public static void main(String[] args) {
        String products = "Application_Practice/PRODUCTS.txt";
        String sales = "Application_Practice/SALES.txt";

        ArrayList<String> productID = new ArrayList<>();
        ArrayList<String> productName = new ArrayList<>();
        ArrayList<Integer> currentStock = new ArrayList<>();
        ArrayList<String> reorderLevel = new ArrayList<>();
        ArrayList<String> unitPrice = new ArrayList<>();

        for (String[] productData : fileReader(products)) {
            productID.add(productData[0]);
            productName.add(productData[1]);
            currentStock.add(Integer.parseInt(productData[2]));
            reorderLevel.add(productData[3]);
            unitPrice.add(productData[4]);
        }

        int stocksLeft;
        for (String[] salesData: fileReader(sales)) {
            for (String data : productID) {
                if (data.equals(salesData[0])) {
                    stocksLeft = currentStock.get(productID.indexOf(data)) - Integer.parseInt(salesData[1]);
                    currentStock.set(productID.indexOf(data), stocksLeft);
                }
            }
        }

        System.out.println(currentStock);
    }

    public static ArrayList<String[]> fileReader (String files) {
        ArrayList<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(files))){

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                dataList.add(data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
