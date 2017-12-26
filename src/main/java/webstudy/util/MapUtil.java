package webstudy.util;

import java.util.Map;

public final class MapUtil {

    public static <K, V> V getFirst(Map<K, V[]> map, K key) {
        V[] values = map.get(key);
        if (values == null || values.length < 1) {
            return null;
        }
        return values[0];
    }
}
