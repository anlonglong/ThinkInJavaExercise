package counter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/5/25 下午3:15
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class LiteralPetCreator extends PerCreator {

    public static final List<Class<? extends Pet>> allTypes
            = Collections.unmodifiableList(Arrays.asList(
                    Pet.class,Dog.class,Cat.class,Mutt.class,Pug.class,Manx.class, Scoff.class));


    public static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
