package DistributionTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

class Evacuee {
    String evacueeID;
    String headOfHousehold;
    String barangay;
    int familySize;
    boolean hasInfantOrElderly;
    boolean isIsolated;

    Evacuee (String evacueeID, String headOfHousehold, String barangay, int familySize, boolean hasInfantOrElderly, boolean isIsolated) {
        this.evacueeID = evacueeID;
        this.headOfHousehold = headOfHousehold;
        this.barangay = barangay;
        this.familySize = familySize;
        this.hasInfantOrElderly = hasInfantOrElderly;
        this.isIsolated = isIsolated;
    }
}

public class DistributionTracker {
    public static void main(String[] args) {

        //VARIABLE DECLARATIONS
        String filePath = "DistributionTracker/evacuation_logs.txt";
        ArrayList <Evacuee> evacuees = new ArrayList<>();

        //START READING FILE
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter("DistributionTracker/relief_allocation.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                evacuees.add(new Evacuee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Boolean.parseBoolean(data[4]),
                        Boolean.parseBoolean(data[5]))
                );
            }

            writer.write("EvacueeID|Barangay|BasePacks|AddOnPacks|TotalPacks");
            writer.newLine();

            int carePack = 1;
            int emergencyRation = 1;
            int householdProcessed = 0;
            int totalReliefPacks = 0;
            int errorHousehold = 0;

            //LOOP THROUGH THE EVACUEES FOR CHECKING
            for (Evacuee member : evacuees){
                int reliefPack = 0;
                int addOns = 0;
                if (member.familySize <= 0) {
                    System.out.printf("Error: Invalid family metrics for Evacuee [%s]", member.evacueeID);
                    System.out.println();
                    errorHousehold++;
                    continue;
                }

                //RELIEF PACKS CONDITIONS
                if (member.familySize >= 7) {
                    reliefPack += 3;
                }
                else if (member.familySize >= 4) {
                    reliefPack += 2;
                }
                else {
                    reliefPack += 1;
                }

                //ADD-ONS
                if (member.hasInfantOrElderly) { addOns += 1; }
                if (member.isIsolated) { addOns += 1; }

                int totalPacks = reliefPack + addOns;
                totalReliefPacks += totalPacks;
                householdProcessed++;
                writer.write(String.format("%s|%s|%d|%d|%d", member.evacueeID, member.barangay, reliefPack, addOns, totalPacks));
                writer.newLine();
            }

            System.out.println("=====================================");
            System.out.println("DISTRIBUTION SUMMARY REPORT");
            System.out.println("=====================================");
            System.out.println("Total Households Processed: " + householdProcessed);
            System.out.println("Total Relief Packs Distributed: " + totalReliefPacks);
            System.out.println("Total Error Households: " + errorHousehold);
            System.out.println("=====================================");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
