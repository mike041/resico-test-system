package cn.resico.test.common.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    private static String defaultFile = "src\\main\\resources\\JDBCConfig.properties";

    public static String getProperties(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(defaultFile)));
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getLongProperties(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(defaultFile));
            return Long.parseLong(properties.getProperty(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static String getProperties(String key, String file) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object setProperties(String key, String value) {
        return setProperties(key, value, defaultFile);
    }

    public static Object setProperties(String key, String value, String file) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
            Object oldValue = properties.get(key);
            properties.setProperty(key, value);
            properties.store(new FileOutputStream(new File(file)), null);
            return oldValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
