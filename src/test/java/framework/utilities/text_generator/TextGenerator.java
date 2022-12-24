package framework.utilities.text_generator;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author Pavel Romanov 23.12.2022
 */
public class TextGenerator {
    public static String generateText() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
