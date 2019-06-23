package javacollection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @Description: map集合数据的填充
 * @CreateDate: 2019/6/23 上午10:28
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    public MapData(Generator<Pair<K, V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generator.next().key, generator.next().value);
        }
    }

    public MapData(Generator<K> gK, Generator<V> gv, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(gK.next(), gv.next());
        }
    }

    public MapData(Iterable<K> genK, Generator<V> genV) {
      while (genK.hasNext()) {
          put(genK.next(), genV.next());
      }
    }


    public static <K, V> MapData<K, V> map(Generator<K> generatorKey, Generator<V> generatorValue, int quality) {
       return new MapData<>(generatorKey, generatorValue, quality);
    }

}
