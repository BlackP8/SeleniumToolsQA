package framework.utilities.data_provider;

import config_util.ConfigManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import test_case3.User;

import java.util.*;

/**
 * @author Pavel Romanov 24.12.2022
 */
public class DataProviderUtil {
    private JSONObject jsonTestObject = null;
    private User user;
    private JSONArray usersList = null;
    private static String testParameter = "test_file";

    @DataProvider(name = "dp")
    public Object[][] getData(ITestContext context) {
        String testParam = context.getCurrentXmlTest().getParameter(testParameter);
        jsonTestObject = ConfigManager.setTestData(testParam);
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

        String[] testData = hashMap.values().toArray(new String[hashMap.size()]);
        Object[][] data = new Object[1][testData.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < testData.length; j++) {
                data[i][j] = testData[j];
            }
        }
        return data;
    }

    @DataProvider(name = "userData")
    public Object[] getUser() {
        jsonTestObject = ConfigManager.setTestData("src/test/resources/test_case3_data.json");
        usersList = (JSONArray) jsonTestObject.get("users");

        Object[] data = new Object[1];
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        String[] userData;

        if (usersList != null) {
            jsonTestObject = (JSONObject) usersList.get(0);
            user = new User(jsonTestObject.get("firstName").toString(), jsonTestObject.get("lastName").toString(),
                    jsonTestObject.get("userEmail").toString(), jsonTestObject.get("age").toString(),
                    jsonTestObject.get("salary").toString(), jsonTestObject.get("department").toString());
//            user.setFirstName((String) jsonTestObject.get("firstName"));
//            user.setLastName((String) jsonTestObject.get("lastName"));
//            user.setEmail((String) jsonTestObject.get("email"));
//            user.setAge((String) jsonTestObject.get("age"));
//            user.setSalary((String) jsonTestObject.get("salary"));
//            user.setDepartment((String) jsonTestObject.get("department"));

            Set<String> jsonObjKeys = jsonTestObject.keySet();

            for (String jsonObjKey: jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonTestObject.get(jsonObjKey));
            }
//            userData = hashMap.values().toArray(new String[hashMap.size()]);
        }
        else {
            throw new RuntimeException();
        }

//        data[0] = user;
//        data[1] = userData;
        return new Object[][] {
                {user, hashMap},
        };
    }
}
