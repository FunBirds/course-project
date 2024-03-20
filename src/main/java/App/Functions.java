package App;

import java.io.*;
import com.opencsv.CSVReader;

public class Functions extends Variables {
    public static void showError(String msg){
        String app_env = getEnv("APP_ENV");
        if (app_env != null && app_env.equals("production")) {
            System.out.println("Something went wrong, please try again later or contact the support team.");
        } else {
            System.out.println(msg);
        }
    }

    public static String getEnv(String name){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".env"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals(name)) {
                        return value;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            return e.getMessage();
        }
        return null;
    }

}
