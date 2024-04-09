package com.assgn3.polynomial.res;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    private static final Properties properties = new Properties();
    public static final String APP_TITLE;
    public static final Boolean IS_FULLSCREEN;

    public Environment() {
    }

    static {
        try {
            properties.load(new FileInputStream(String.format("%s%s", System.getProperty("user.dir"), "/1.properties")));
        } catch (IOException var1) {
            throw new RuntimeException(var1);
        }

        APP_TITLE = properties.getProperty("APP_TITLE");
        IS_FULLSCREEN = Boolean.valueOf(properties.getProperty("IS_FULLSCREEN"));
    }
}