package framework.utilities.data_provider;

import framework.logger.Log;
import framework.utilities.config_util.ConfigManager;
import framework.utilities.wait_util.WaitUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import data_model.User;

import java.util.*;

/**
 * @author Pavel Romanov 24.12.2022
 */
public class DataProviderUtil {
    private JSONObject jsonTestObject = null;
    private User user;
    private JSONArray usersList = null;
    private static String testFile = "test_file";
    private static String testObjects = "test_objects";
    private static String firstName = "first_name";
    private static String lastName = "last_name";
    private static String email = "email";
    private static String age = "age";
    private static String salary = "salary";
    private static String dep = "department";

    @DataProvider(name = "dp")
    public Object[][] getData(ITestContext context) {
        Log.logUtils(DataProviderUtil.class.getName() + ": Загружаем тестовые данные.");
        String testParam = context.getCurrentXmlTest().getParameter(testFile);
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
    public Object[][] getUser(ITestContext context) {
        Log.logUtils(DataProviderUtil.class.getName() + ": Загружаем модель данных.");
        String file = context.getCurrentXmlTest().getParameter(testFile);
        String usersParameter = context.getCurrentXmlTest().getParameter(testObjects);
        String fNameParameter = context.getCurrentXmlTest().getParameter(firstName);
        String lNameParameter = context.getCurrentXmlTest().getParameter(lastName);
        String emailParameter = context.getCurrentXmlTest().getParameter(email);
        String ageParameter = context.getCurrentXmlTest().getParameter(age);
        String salaryParameter = context.getCurrentXmlTest().getParameter(salary);
        String depParameter = context.getCurrentXmlTest().getParameter(dep);
        jsonTestObject = ConfigManager.setTestData(file);
        usersList = (JSONArray) jsonTestObject.get(usersParameter);

        List<User> users = new ArrayList<>();

        if (usersList != null) {
            for (int i = 0; i < usersList.size(); i++) {
                jsonTestObject = (JSONObject) usersList.get(i);
                user = new User(jsonTestObject.get(fNameParameter).toString(), jsonTestObject.get(lNameParameter).toString(),
                        jsonTestObject.get(emailParameter).toString(), jsonTestObject.get(ageParameter).toString(),
                        jsonTestObject.get(salaryParameter).toString(), jsonTestObject.get(depParameter).toString());
                users.add(user);
            }
        }
        else {
            throw new RuntimeException();
        }

        return new Object[][] {{users.get(0)}, {users.get(1)}};
    }
}
