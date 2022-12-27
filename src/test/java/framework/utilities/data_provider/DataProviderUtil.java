package framework.utilities.data_provider;

import framework.utilities.config_util.ConfigManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Pavel Romanov 24.12.2022
 */
public class DataProviderUtil {
    private JSONParser parser = new JSONParser();
    private JSONObject jsonTestObject = null;
    private JSONArray usersList = null;
    private static String testParameter = "test_file";

    @DataProvider(name = "dp")
    public Object[] getData(ITestContext context) {
        String testParam = context.getCurrentXmlTest().getParameter(testParameter);
        jsonTestObject = ConfigManager.setTestData(testParam);

        Object[] data = new Object[1];
        HashMap<String, String> hashMap = new LinkedHashMap<>();

        if (jsonTestObject != null) {
            Set<String> jsonObjKeys = jsonTestObject.keySet();

            for (String jsonObjKey: jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonTestObject.get(jsonObjKey));
            }
        }
        else {
            throw new RuntimeException();
        }

        data[0] = hashMap;
        return data;
    }

    @DataProvider(name = "userData")
    public Object[] getUser() {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test_case3_data.json"))) {
            Object obj = parser.parse(reader);
            jsonTestObject = (JSONObject) obj;
            usersList = (JSONArray) jsonTestObject.get("users");
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Object[] data = new Object[1];
        HashMap<String, String> hashMap = new LinkedHashMap<>();

        if (usersList != null) {
            jsonTestObject = (JSONObject) usersList.get(0);
            Set<String> jsonObjKeys = jsonTestObject.keySet();

            for (String jsonObjKey: jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonTestObject.get(jsonObjKey));
            }
        }
        else {
            throw new RuntimeException();
        }

        data[0] = hashMap;
        return data;
    }
}
