package App;

import java.util.ArrayList;
import java.util.List;

public class Variables {
     static String database = Functions.getEnv("DB_URL");

     public static List<String> available_commands = new ArrayList<>();

}
