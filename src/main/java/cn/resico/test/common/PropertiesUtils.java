package cn.resico.test.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static String defaultFile = "src\\main\\resources\\config";

    public static String getProperties(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(defaultFile));
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
