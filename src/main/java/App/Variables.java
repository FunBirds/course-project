package App;

import java.util.ArrayList;
import java.util.List;

import static App.Functions.*;

public class Variables {
     static String database = getEnv("DB_URL");

     public static List<String> available_commands = new ArrayList<>();

}
