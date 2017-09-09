package jp.co.tis.adc.webstudy.util;

import jodd.bean.BeanCopy;
import jodd.bean.BeanUtil;

import java.util.Map;
import java.util.Map.Entry;

public final class SimpleBeanUtil {

    public static <T> T create(Map<String, String[]> data, Class<T> clazz) {

        
        final T obj = newInstance(clazz);
        for (Entry<String, String[]> entry : data.entrySet()) {
            String propName = entry.getKey();
            if (BeanUtil.pojo.hasProperty(obj, propName)) {
                String value = entry.getValue()[0];
                BeanUtil.pojo.setProperty(obj, propName, value);
            }
        }
        return obj;
    }


    private static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException |IllegalAccessException e) {
            throw new IllegalStateException(e);
        }

    }
}
