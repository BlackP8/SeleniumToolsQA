package framework.utilities.text_util;

import java.util.List;
import java.util.UUID;

/**
 * @author Pavel Romanov 26.12.2022
 */
public class TextUtility {

    public static int checkTextContains(String text1, String text2, List<String> data) {
        int count = 0;
        String[] text = new String[data.size()];
        text[0] = text1;
        text[1] = text2;
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < data.size(); j++) {
                if (text[i].contains(data.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String generateText() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }
}
