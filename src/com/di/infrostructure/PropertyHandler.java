/*
 * @author Aliaksei Vazdusevich
 */

package com.di.infrostructure;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertyHandler {
    private static final String PATH = "resources/application.properties";
    private static final Properties properties = new Properties();

    private PropertyHandler() {
    }

    public static Optional<String> getProperty(String key) {
        if (properties.size() == 0) {
            load();
        }
        return Optional.ofNullable(properties.getProperty(key));
    }

    private static void load()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read properties");
        }
    }
}
