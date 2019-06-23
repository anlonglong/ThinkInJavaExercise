package counter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/5/25 下午3:05
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public abstract class PerCreator {
    private Random mRandom = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int nextInt = mRandom.nextInt(types().size());
        try {
           return types().get(nextInt).newInstance();
        } catch (IllegalAccessException|InstantiationException e) { throw new RuntimeException();
        }
    }

    public Pet[] createArrat(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0 ; i < size ; i ++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> pets = new ArrayList<>(size);
        Pet[] arrat = createArrat(size);
        Collections.addAll(pets, arrat);
        return pets;
    }

}
