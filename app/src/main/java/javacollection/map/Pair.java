package javacollection.map;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/23 上午10:28
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class Pair<K, V> {

    public final K key;

    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
