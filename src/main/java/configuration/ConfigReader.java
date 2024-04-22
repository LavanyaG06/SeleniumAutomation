package configuration;

import java.io.*;
import java.util.*;

public class ConfigReader {

    public static Properties getConfigProperty() {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/lavanyagandra/Documents/Professional/testing/WebQAAutomation/src/main/resources/config.properties");
            properties.load(input);
            System.out.println(properties.getProperty("user"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
