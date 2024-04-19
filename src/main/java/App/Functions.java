package App;

import java.io.*;
import java.util.Objects;

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
            showError(e.getMessage());
        }
        return null;
    }


    // in this function we write a step for user.
    public static void writeSteps(String step){
        try (FileWriter writer = new FileWriter("./src/main/java/Database/steps.txt")) {
            writer.write(step);
        } catch (IOException e) {
            showError(e.getMessage());
        }
    }

    public static StringBuilder readSteps(){
        try {
            BufferedReader read = new BufferedReader(new FileReader("./src/main/java/Database/steps.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                content.append(line);
            }
            return content;
        }
        catch (IOException e) {
            showError(e.getMessage());
        }
        return null;
    }

    public static void helloMsg() throws InterruptedException {
        System.out.println("Hello! Welcome to the Warhouse search App");
        System.out.println("We are making a connection to the database... please be patient");
        if (getEnv("APP_ENV") != null && Objects.equals(getEnv("APP_ENV"), "production")) {
            Thread.sleep(2000); // 2 seconds delay to simulate the connection that is not exist in product | For better view
        }
        System.out.println("Done! Connection established");
        System.out.println("This app made by Abdullajonov Boburjon! Type \"/help\" to see all aviable comand");
    }

    public static void bye(){
        System.out.println("Goodbye! Have a nice day!");
    }
}
