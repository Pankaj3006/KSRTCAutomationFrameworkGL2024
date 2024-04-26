package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import com.pan.enums.PropertyType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReaderUtils {

    private static Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.CONFIG_PATH);
            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                map.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(PropertyType key) {
        return map.get(key.getValue());
    }
}
