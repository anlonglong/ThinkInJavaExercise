package generict;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/9 上午9:34
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class GenericArray2<T> {

    private Object[] array;

    public GenericArray2(int size) {
        this.array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public T[] rep() {
        return (T[]) array;
    }

}
