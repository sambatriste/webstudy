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
     *
     * @param data  生成元となるMap
     * @param clazz 生成されるBeanの{@link Class}
     * @param <T>   Beanの型
     * @return 生成されたBean
     */
    public static <T> T create(Map<String, String[]> data, Class<T> clazz) {

        final T obj = newInstance(clazz);
        copy(data, obj);
        return obj;
    }

    /**
     * 値のコピーを行う。
     * @param src コピー元Map
     * @param dest コピー先Object
     */
    public static void copy(Map<String, String[]> src, Object dest) {
        for (Entry<String, String[]> entry : src.entrySet()) {
            String propName = entry.getKey();
            if (BeanUtil.pojo.hasProperty(dest, propName)) {
                String value = entry.getValue()[0];
                BeanUtil.pojo.setProperty(dest, propName, value);
            }
        }
    }


    /**
     * 指定された{@link Class}からそのインスタンスを生成する。
     *
     * @param clazz 生成するクラス
     * @param <T>   クラスの型
     * @return インスタンス
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(
                    "could not instansiate [" + clazz + "]",
                    e);
        }
    }
}
