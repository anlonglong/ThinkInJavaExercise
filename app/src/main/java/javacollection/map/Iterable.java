package javacollection.map;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/23 上午10:39
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public interface Iterable<E> {

    E next();

    boolean hasNext();

    void remove();
}
