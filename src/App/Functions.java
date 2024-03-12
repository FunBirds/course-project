package App;

import java.io.*;

public class Functions {
    public static void showError(String $msg){
        String app_env = Variables.getenv();
        if (app_env.equals("production")) {
            System.out.println("Something went wrong");
        } else {
            System.out.println($msg);
        }
    }

    public static void getEnv(String name){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".envs"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals(name)) {
                        Variables.setAppEnv(value);
                        break;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            showError(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
