import net.dv8tion.jda.api.JDABuilder;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Tsubasa {

    public static void main(String[] args){

        //Create a store for config
        JSONObject config = loadConfig();

        //Get the token from the config
        String token = config.get("token").toString();

        //Create a JDA builder for building the Discord API
        JDABuilder builder = JDABuilder.createDefault(token);
    }


    /**
     * Load config from the json file
     * @return the json file
     */
    public static JSONObject loadConfig() {

        //Create path for config json file
        Path configPath = Paths.get("config.json");

        //Wrap in try catch to get exceptions
        try {
            //Check if the file exists
            if(!Files.exists(configPath)){
                //Create the file and throw an exception
                Files.createFile(configPath);
                throw new Exception("config file not found, created config file in root directory");
            }

            //If the file exists then we read it
            List<String> config = Files.readAllLines(configPath);

            //check if the config is empty
            if(config.size() == 0) { throw new Exception("config file is empty or corrupted."); }

            //Create a config string from the string list
            String configString = toJsonString(config);

            //Return a new JSONObject based on the config string we got
            return new JSONObject(configString);
        }
        //Catch any IOExceptions and trace their stacks
        catch (IOException e) {
            e.printStackTrace();
        }
        //Catch exception that there was no config file
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Convert a list of strings to a single string
     * @param list
     * @return
     */
    public static String toJsonString(List<String> list){

        //Create the string builder
        StringBuilder jsonBuilder = new StringBuilder();

        //Iterate through all strings in the list
        for(String string : list){

            //append the current string to the JSONBuilder
            jsonBuilder.append(string);
        }

        return jsonBuilder.toString();
    }
}
