package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The CommandController class is responsible for parsing command strings.
 * It uses regular expressions to identify and extract command options and their values.
 */
public class CommandController {
    /**
     * The searchCommand method takes a command string as input and returns a map of command options and their values.
     * It uses a regular expression to identify command options, which are expected to be in the format -option=value.
     * @param command A string containing the command to be parsed.
     * @return A map where the keys are command options and the values are the corresponding values from the command string.
     */
    public Map<String, String> searchCommand(String command){
        // The pattern for identifying command options in the command string
        Pattern pattern = Pattern.compile("(-[a-zA-Z]+)=([^\\s]+)");
        // The output map to be returned
        Map<String, String> output = new HashMap<>();
        // A matcher for finding matches of the pattern in the command string
        Matcher matcher = pattern.matcher(command);
        // Loop over all matches in the command string
        while (matcher.find()){
            // Extract the command option from the match
            String key = matcher.group(1);
            // Extract the value from the match
            String value = matcher.group(2);
            // Add the command option and its value to the output map
            output.put(key, value);
        }
        // Return the output map
        return output;
    }
}