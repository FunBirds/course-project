package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandController {
    public Map<String, String> searchCommand(String command){
        // /search -t=cup -p=color -a=red
        Pattern pattern = Pattern.compile("(-[a-zA-Z]+)=([^\\\\s-]+)");
        Map<String, String> output = new HashMap<>();
        System.out.println("Enter the command: ");
        if(command.contains("/search")){
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()){
                String key = matcher.group(1);
                String value = matcher.group(2);
                output.put(key, value);
            }
            if (output.isEmpty()){
                System.out.println("Invalid Command");
            }
        }
        return output;
    }
}
