package App;
import com.opencsv.CSVReader;
import java.io.*;
import java.util.*;
public class DB extends Variables {
    public static void readAll(){
        try {
            // Create CSVReader object with FileReader
            CSVReader reader = new CSVReader(new FileReader(database));

            List<String[]> data = reader.readAll();

            // Print header
            System.out.println("Inventory Data:");
            String[] header = data.get(0);
            for (String field : header) {
                System.out.print(field + ",");
            }
            System.out.println();

            // Print data rows
            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                for (String value : row) {
                    System.out.print(value + ",");
                }
                System.out.println();
            }

            reader.close();

        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }


    public static String search(String name){
        List<String> data = new ArrayList<>();
        try {
            assert null != database;
            CSVReader reader = new CSVReader(new FileReader(database));

            // it skips header line
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(name)) {
                    data.add("Products Found!!! \n");
                    data.add("Product Name: " + line[0]);
                    data.add("Product ID: " + line[1]);
                    data.add("Product Category: " + line[2]);
                    data.add("Quantity: " + line[3]);
                    data.add("Price: " + line[4] + "$");
                    return String.join(" | ", data);
                }
            }
            reader.close();
        } catch (Exception e) {
            Functions.showError(e.getMessage());
        }
        return null;
    }

}
