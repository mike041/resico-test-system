package cn.resico.test.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ParsingObject {

    private static String[] getFieldNames(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldsNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldsNames[i] = fields[i].getName();
        }
        return fieldsNames;
    }

    private static Object getFieldValueByName(String name, Object o) {
        try {
            String firstLetter = name.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + name.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[] getFieldValue(Object o) {
        String[] fieldNames = ParsingObject.getFieldNames(o);
        List list = new ArrayList();
        for (int i = 0; i < fieldNames.length; i++) {
            Object fieldValue = ParsingObject.getFieldValueByName(fieldNames[i], o);
            list.add(fieldValue);
        }
        return list.toArray();
    }


}
