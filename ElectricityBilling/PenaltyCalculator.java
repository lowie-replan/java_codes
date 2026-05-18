package ElectricityBilling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

class ConsumerData {
    private String accountID;
    private String consumerName;
    private String consumerType;
    private int previousReading;
    private int currentReading;
    private boolean isOverdue;

    ConsumerData (String accountID, String consumerName, String consumerType, int previousReading, int currentReading, boolean isOverdue) {
        this.accountID = accountID;
        this.consumerName = consumerName;
        this.consumerType = consumerType;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.isOverdue = isOverdue;
    }

    public String getAccountID() {return accountID;}
    public String getConsumerName() {return consumerName;}
    public String getConsumerType() {return  consumerType;}
    public  int getPreviousReading() {return previousReading;}
    public  int getCurrentReading() {return currentReading;}
    public boolean getIsOverdue() {return isOverdue;}
}
public class PenaltyCalculator {
    public static void main(String[] args) {
        String filePath = "ElectricityBilling/consumers.txt";
        ArrayList<ConsumerData> consumerData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("ElectricityBilling/billing_manifest.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                consumerData.add(new ConsumerData(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        Boolean.parseBoolean(data[5])
                ));
            }

            int powerConsumed;
            double consumption;
            double totalConsumption = 0;
            double penalty;
            double rate;
            writer.write("AccountID | ConsumerName | kWhConsumed | PenaltyApplied | FinalBillAmount");
            writer.newLine();
            for (ConsumerData data : consumerData) {
                powerConsumed = data.getCurrentReading() - data.getPreviousReading();
                if (powerConsumed <= 0) {
                    System.out.printf("Error: Invalid reading for Account [%s]", data.getAccountID());
                    continue;
                }

                if (data.getConsumerType().equals("Residential")) {
                    if (powerConsumed <= 200) {
                        consumption = 9.50 * powerConsumed;
                    }
                    else {
                        double temp = powerConsumed - 200;
                        consumption = (200 * 9.50) + (temp * 12);
                    }
                }
                else {
                    consumption = 14 * powerConsumed;
                }

                if (data.getIsOverdue()) {
                    penalty = consumption * 0.10;
                }
                else {
                    penalty = 0;
                }
                totalConsumption = penalty + consumption;
                writer.write(String.format("%s | %s | %d | %.2f | %.2f", data.getAccountID(), data.getConsumerName(), powerConsumed, penalty, totalConsumption));
                writer.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
