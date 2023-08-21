package org.example.campus.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestValueProvider {
    private final static String PROPERTIES_PATH = "src/test/resources/data.properties";
    private final Properties properties;

    public TestValueProvider() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLoginPageUrl() {
        return properties.getProperty("baseUIUrl");
    }

    public String getCorrectPassword() {
        return properties.getProperty("correctPassword");
    }

    public String getIncorrectPassword() {
        return properties.getProperty("incorrectPassword");
    }

    public String getCorrectLogin() {
        return properties.getProperty("correctLogin");
    }

    public String getInCorrectLogin() {
        return properties.getProperty("incorrectLogin");
    }
}
