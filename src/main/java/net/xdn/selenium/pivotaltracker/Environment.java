package net.xdn.selenium.pivotaltracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.apache.commons.io.IOUtils.closeQuietly;

/**
 * Created by Ariel Mattos on 4/19/2017.
 */
public final class Environment {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    private static Environment instance;
    private Properties properties;

    /**
     * Environment object private constructor.
     */
    private Environment() {
        InputStream gradleProperty = null;

        try {
            gradleProperty = new FileInputStream("gradle.properties");
            InputStreamReader inputStreamReader = new InputStreamReader(gradleProperty, StandardCharsets.UTF_8);
            properties = new Properties();
            properties.load(inputStreamReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gradleProperty != null) {
                closeQuietly(gradleProperty);
            }
        }
    }

    /**
     * Returns the instance of the Environment object.
     * @return the Environment instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Returns the specified environment property.
     * @param property      the property to be returned.
     * @return a String containing the value of the property, null otherwise.
     */
    public String getEnv(final String property) {
        String env = System.getProperty(property); // command line
        if (env == null) {
            env = properties.getProperty(property); // file
        }
        return env;
    }

    /**
     * Returns the username property.
     * @return a String containing the username property.
     */
    public String getUsername() {
        return getEnv(USERNAME);
    }

    /**
     * Returns the password property.
     * @return a String containing the password property.
     */
    public String getPassword() {
        return getEnv(PASSWORD);
    }
}
