package cn.resico.test.common.utils;

import cn.resico.test.common.hook.Hook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FunctionUtil {
    public static boolean isFunction(String param) {
        // TODO: 2021/4/16  
        return true;
    }

    public static String getValue(String funcName, String... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Hook hook = Hook.class.getConstructor(null).newInstance();
        Method m = Hook.class.getDeclaredMethod(funcName, args.getClass());
        return (String) m.invoke(hook, args);
    }
}
