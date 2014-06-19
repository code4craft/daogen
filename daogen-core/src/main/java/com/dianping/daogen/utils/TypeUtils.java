package com.dianping.daogen.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 */
public abstract class TypeUtils {

    private static Map<String, String> suggestValueMap = new HashMap<String, String>() {{
        put(Integer.TYPE.getName(), "10");
        put(Integer.class.getName(), "10");
        put(String.class.getName(), "\"Apollo DaoGen guagua\"");
        put(Date.class.getName(), "new Date()");
    }};

    private static Map<String, String> boxTypeMap = new HashMap<String, String>() {{
        put(Integer.TYPE.getName(), Integer.class.getName());
        put(Double.TYPE.getName(), Double.class.getName());
    }};

    public static String getSuggestValue(String type) {
        return String.valueOf(suggestValueMap.get(type));
    }

    public static String getBoxedType(String type) {
        String boxType = boxTypeMap.get(type);
        if (boxType != null) {
            return boxType;
        }
        return type;
    }
}
