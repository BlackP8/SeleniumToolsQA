package framework.utilities.config_util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavel Romanov 22.12.2022
 */
public class ConfigManager {
    private static final String PATH_TO_CONFIG_FILE = "src/test/resources/configuration.json";
    private static JSONParser parser = new JSONParser();
    private static JSONObject jsonConfObject;
    private static JSONObject jsonTestObject;

    public static void setConfig() {
        try(BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_CONFIG_FILE))) {
            Object obj = parser.parse(reader);
            jsonConfObject = (JSONObject)obj;
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject setTestData(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Object obj = parser.parse(reader);
            jsonTestObject = (JSONObject)obj;
            return jsonTestObject;
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getTestProperty(String key) {
        return (String) jsonTestObject.get(key);
    }

    public static String getConfProperty(String key) {
        return (String) jsonConfObject.get(key);
    }
}
