package generict;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/9 上午9:47
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class GerericArrayWithTypeToken<T> {

    private T[] array;

    public GerericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
       return array[index];
    }

    public T[] repo() {
        return array;
    }


}
