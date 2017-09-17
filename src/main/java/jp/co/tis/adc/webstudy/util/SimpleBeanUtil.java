package jp.co.tis.adc.webstudy.util;

import jodd.bean.BeanUtil;

import java.util.Map;
import java.util.Map.Entry;

/**
 * 簡易的なBean操作を行うためのユーティリティクラス.
 */
public final class SimpleBeanUtil {

    /**
     * {@code Map<String, String[]>}からBeanを生成する.
     * @param data 生成元となるMap
     * @param clazz 生成されるBeanの{@link Class}
     * @param <T> Beanの型
     * @return 生成されたBean
     */
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


    /**
     * 指定された{@link Class}からそのインスタンスを生成する。
     * @param clazz 生成するクラス
     * @param <T> クラスの型
     * @return インスタンス
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException |IllegalAccessException e) {
            throw new IllegalStateException(
                    "could not instansiate [" + clazz + "]",
                    e);
        }
    }
}
