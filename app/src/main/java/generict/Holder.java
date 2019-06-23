package generict;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/9 上午9:22
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class Holder<T> {

    private T value;

    public Holder() {}

    public Holder(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals( Object obj) {
        return super.equals(obj);
    }
}
